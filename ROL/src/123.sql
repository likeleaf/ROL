create or replace procedure comm.weixin_cz(v_pat_id   in  MEDREC.pb_vip_id.patient_id%type,
                                             v_je     in number,
                                             v_success_flag out number,
                                             v_fail_cause   out varchar2) is
  v_patient_id    MEDREC.pb_vip_id.patient_id%type;
  v_id_ye_pass    MEDREC.pb_vip_id.id_ye_pass%type;
  v_id_ye         MEDREC.pb_vip_id.id_ye_pass%type;
  v_idye          MEDREC.pb_vip_id.id_ye%type;
  ldt_sysdate     MEDREC.pb_vip_czmx.oper_date%type;
  ls_sysdate      varchar2(8);
  ll_prepay_no     number;
  v_rcpt_no      varchar2(20);
begin
  begin
  select patient_id,id_ye,gf_password(patient_id||to_char(id_ye,'FM9999999.00'),'加密'),id_ye_pass into   v_patient_id,v_idye,v_id_ye,v_id_ye_pass from MEDREC.pb_vip_id where patient_id=v_pat_id and id_status=1;
 exception
   when no_data_found then
    v_success_flag := -1;
    v_fail_cause   :=v_pat_id|| '档案号不存在...' || sqlcode || '...' || sqlerrm ||
                      '...' || dbms_utility.format_error_backtrace();
    return;
    when others then
    v_success_flag := -1;
    v_fail_cause   := '验证档案号出错...' || sqlcode || '...' || sqlerrm || '...' ||
                      dbms_utility.format_error_backtrace();
  end ;
 if v_id_ye<>v_id_ye_pass then
   v_success_flag := -1;
   v_fail_cause   :=v_pat_id|| '检验余额密码出错,请与信息中心联系!' ;
   return;
 end if ;
 if v_je>5000 then
   v_success_flag := -1;
   v_fail_cause   :=v_pat_id|| '一次最大充值不能大于5000元!' ;
   return;
 end if;
 if v_je=0 then
    v_success_flag := -1;
   v_fail_cause   :=v_pat_id|| '充值金额不能为0元!' ;
   return;
 end if;
 if v_je<0 and v_idye<abs(v_je) then
   v_success_flag := -1;
   v_fail_cause   :=v_pat_id|| '余额不足!' ;
   return;
 end if;

 begin
   v_id_ye_pass := gf_password(v_pat_id || to_char(v_idye + v_je,'FM99999990.00'),'加密');
   update MEDREC.pb_vip_id set id_ye=id_ye+v_je,id_ye_pass=v_id_ye_pass where patient_id=v_pat_id;
   exception
   when no_data_found then
    v_success_flag := -1;
    v_fail_cause   := '没有找到对应的数据...' || sqlcode || '...' || sqlerrm ||
                      '...' || dbms_utility.format_error_backtrace();
   rollback;
    return;
  when others then
    v_success_flag := -1;
    v_fail_cause   := '更新余额过程中出现错误...' || sqlcode || '...' || sqlerrm || '...' ||
                      dbms_utility.format_error_backtrace();
    rollback;
    return;
  end ;

  begin
   Select sysdate,to_char(sysdate,'yyyymmdd'),outpadm.prepay_no.NextVal Into ldt_sysdate,ls_sysdate,ll_prepay_no From dual;
   exception
    when no_data_found then
    v_success_flag := -1;
    v_fail_cause   :=v_pat_id|| '充值序列不存在...' || sqlcode || '...' || sqlerrm ||
                      '...' || dbms_utility.format_error_backtrace();
    return;
    when others then
    v_success_flag := -1;
    v_fail_cause   := '取充值序列出错...' || sqlcode || '...' || sqlerrm || '...' ||
                      dbms_utility.format_error_backtrace();
    end;
    begin
    v_rcpt_no := ls_sysdate || to_char(ll_prepay_no,'FM0000000');
    InSert Into pb_vip_czmx(vip_no,vip_czje,oper_date,oper_no,rcpt_no,pay_way,memo,patient_id,win_no,vip_ye,card_bank,card_bank_no,trade_id)
    Values('',v_je,sysdate,'1111',v_rcpt_no,'微信','自助充值',v_pat_id,'099',v_idye + v_je,'','','');
     exception

   when no_data_found then
    v_success_flag := -1;
    v_fail_cause   := '插入充值明细没有找到对应的数据...' || sqlcode || '...' || sqlerrm ||
                      '...' || dbms_utility.format_error_backtrace();
   rollback;
    return;
  when others then
    v_success_flag := -1;
    v_fail_cause   := '插入充值明细过程中出现错误...' || sqlcode || '...' || sqlerrm || '...' ||
                      dbms_utility.format_error_backtrace();
    rollback;
    return;
 end;
  v_success_flag:=0;
  v_fail_cause:='成功';
  commit;
end weixin_cz;
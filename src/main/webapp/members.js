/**
 * 
 */
 
 function infoConfirm() {
	if(document.reg_frm.id.value.length == 0) {
		alert("ID는 필수사항 입니다.");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.pw.value.length == 0) {
		alert("Password는 필수사항 입니다.");
		reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.name.value.length == 0) {
		alert("Name은 필수사항 입니다.");
		reg_frm.name.focus();
		return;
	}
	
	if(document.reg_frm.e_mail.value.length == 0) {
		alert("E-Mail은 필수사항 입니다.");
		reg_frm.e_mail.focus();
		return;
	}
	
	if(document.reg_frm.id.value.length < 5) {
		alert("ID는 4글자 이상으로 입력하세요.");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.pw.value.length < 5) {
		alert("Password는 4글자 이상으로 입력하세요.");
		reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value) {
		alert("Password가 일치하지 않습니다.");
		reg_frm.pw.focus();
		return;
	}
	
	document.reg_frm.submit();
	
}
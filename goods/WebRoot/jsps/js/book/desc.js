$(function() {
	$("#cnt").blur(function() {
		var quantity = $("#cnt").val();
		if(!/^[1-9]\d*$/.test(quantity)) {
			alert("���������ǺϷ�������");
			$("#cnt").val("1");
		}
	});
});
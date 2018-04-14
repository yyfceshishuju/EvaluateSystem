$(document).ready(function() {
	var t = document.getElementById("exept");
	if (t != null) {
		if (t.innerHTML != "undifiend") {
			var e = document.getElementById("headid");
			e.style.display = "none";
		}
	}
	$("#headButton").click(function() {
		$("#headDiv").show();
		$(".registation").show();
		$("#reset").show();
		this.style.display = "none";
		var table = $("table");
		$("#carbonForm").width("700px");
		$("#carbonForm").height(table.height() + 320);
		$(".formRow").height(table.height() + 10);
		$(".evaluateTableHead").css("margin-left", "150px");
		$("#carbonForm>h1").css("margin-left", "170px");
		$("#backgrondb").height(table.height() + 500);
	}

	);

}

);

function checkRadio(l) {
	for ( var i = l.length; i--;) {
		if (l[i].checked) {
			return l[i].value;
		}
	}
	return false;
}

function textarea(l) {
	for ( var i = l.length; i--;) {
		if (l[i].value.length < 150) {
			return true;
		}
	}
	return false;
}
function buttonSubmit() {
	var selectsize = $(":radio").length / 5;
	var inputsize = $("textarea").length;
	for ( var i = 1; i <= selectsize; i++) {
		var a = document.getElementsByName("selectEvaluateItemDetailMap['" + i
				+ "']");
		if (!checkRadio(a)) {
			alert("请给第  " + i + "  项评分");
			return false;
		}
	}
	for ( var i = 1; i <= inputsize; i++) {
		var a = document.getElementsByName("inputeEvaluateItemDetailMap['" + i
				+ "']");
		var val = a[0].value;
		var tempt = val.indexOf(";");
		var tempt1 = val.indexOf("；");
		if (tempt != -1 || tempt1 != -1) {
			alert("请不要输入分号！");
			return false;
		}
		if (!textarea(a)) {
			alert("输入内容过长");
			return false;
		}
	}

	return true;
}

function textarea250(e) {
	textareac = document.getElementsByTagName("textarea");
	textareac[e].className = 'textarea2';

}
function textarea260(a) {
	textareac[a].className = 'textarea1';

}
function removeBox() {
	var $box = $("#" + BOXID.___boxID);
	var $boxbg = $("#XYTipsWindowBg");
	if ($box != null || $boxbg != null) {
		var $contentID = $(".___boxContent", $box);
		$contentType = BOXID.___content.substring(0, BOXID.___content
				.indexOf(":"));
		$content = BOXID.___content.substring(
				BOXID.___content.indexOf(":") + 1, BOXID.___content.length);
		if ($contentType == "id") {
			$contentID.children().appendTo($("#" + $content));
			$box.parent().removeAttr("style").remove();
			$boxbg.animate({
				opacity : "0"
			}, 500, function() {
				$(this).remove();
			});
			$("body").css("background", "#cff909c");
		} else {
			$box.parent().removeAttr("style").remove();
			$boxbg.animate({
				opacity : "0"
			}, 500, function() {
				$(this).remove();
			});
			$("body").css("background", "#cff909c");
		}
		;
	}
	;
}

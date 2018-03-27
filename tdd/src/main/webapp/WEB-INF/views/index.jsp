<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator Main</title>
    <script src="https://code.jquery.com/jquery-2.2.1.js"></script>
    <script>
        $(document).ready(function(){
            $("#calBtn").click(function(){
                $.ajax({
                    type : "POST",
                    url : "/calculatorHistories",
                    contentType: "application/json",
                    dataType: "json",
                    data: JSON.stringify({value1 : $("#value1").val(), operation : $("#operation").val(), value2 : $("#value2").val()}),
                    error: function (xhr, status) {
                        alert("An error occurred: " + status);
                    },
                    success : function(calculatorHistory){
                        alert("통신데이터 값 : " + calculatorHistory) ;
                        $("#result").html(calculatorHistory.result) ;
                    }

                })
            });


        });
    </script>
</head>
<body>
<form id="calculatorForm">
    <input type="text" id="value1">
    <select id="operation">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="text" id="value2">
    <input type="button" id="calBtn" value="확인">
    <span id="result"></span>
</form>

<br><br>

</body>
</html>
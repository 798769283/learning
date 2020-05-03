var QuestionJosn;
$(function(){
    var id =$("#questionId").val();
    $.get("/learning/getQuestions",{id:id},function (data) {
        QuestionJosn=$.parseJSON(data);
        alert(JSON.stringify(QuestionJosn)+"-----");
    })
})
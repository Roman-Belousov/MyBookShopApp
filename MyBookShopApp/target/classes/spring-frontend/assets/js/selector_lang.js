$("select").on("click" , function() {

    $(this).parent(".select-box").toggleClass("open");

});

$(document).mouseup(function (e)
{
    var container = $(".select-box");

    if (container.has(e.target).length === 0)
    {
        container.removeClass("open");
    }
});


$("select").on("change" , function() {

    var selection = $(this).find("option:selected").text(),
        labelFor = $(this).attr("id"),
        label = $("[for='" + labelFor + "']");

    label.find(".label-desc").html(selection);

});

$(document).ready(function (){
    $("#locales").change(function (){
        var selectedOption = $("#locales").val();
        if(selectedOption !=''){
            window.location.replace('?lang=' + selectedOption);
        }
    });
});
$(document).ready(function(){
    $(".modal").modal();
    $('select').material_select();
    $('#textarea1').val("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    $('#textarea1').trigger("");

    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15 // Creates a dropdown of 15 years to control year
    });

    $("#search_btn_search").focus(function(){
        $("#search_lb_search").css({"display":"none"});
    });

    $("#search_btn_search").focusout(function(){
        $("#search_lb_search").css({"display":"block"});
    });
});

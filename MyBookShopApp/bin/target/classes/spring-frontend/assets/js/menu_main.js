
$(function() {
    $('.menu_main [href]').each(function() {
        if (this.href == window.location.href) {
            $(this).addClass('menu-item menu-item_ACTIVE');
        }
    });
});






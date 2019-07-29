$(document).ready(function () {

    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit
        var idText =  $('.myForm #id').text();
        console.log(text);
        console.log(text === 'Edit');
        if (text === 'Edit') {
            $.get(href, function (vehicle, status) {
                $('.myForm #idLabel').text(vehicle.id);
                $('.myForm #id').val(vehicle.id);
                $('.myForm #brand').val(vehicle.brand);
                $('.myForm #model').val(vehicle.model);
                $('.myForm #plate').val(vehicle.plate);
                $('.myForm #licenseRequired').val(vehicle.licenseRequired);
            });
            $('.myForm #exampleModal').modal();
        } else {
            $('.myForm #idLabel').text('');
            $('.myForm #id').text('');
            $('.myForm #brand').val('');
            $('.myForm #model').val('');
            $('.myForm #plate').val('');
            $('.myForm #licenseRequired').val('');
            $('.myForm #exampleModal').modal();
        }
    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    });
});
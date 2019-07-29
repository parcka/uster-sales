$(document).ready(function () {


    // Vehicles Functionality

    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

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

    // Vehicles Functionality


    // Driver Functionality

    $('.nBtnDriver, .table .eBtnDriver').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (driver, status) {
                console.log(driver)
                $('.myForm #idLabel').text(driver.id);
                $('.myForm #id').val(driver.id);
                $('.myForm #name').val(driver.name);
                $('.myForm #surname').val(driver.surname);
                $('.myForm #license').val(driver.license);

            });
            $('.myForm #exampleModal').modal();
        } else {
            $('.myForm #idLabel').text('');
            $('.myForm #id').val('');
            $('.myForm #name').val('');
            $('.myForm #surname').val('');
            $('.myForm #license').val('');
            $('.myForm #exampleModal').modal();
        }
    });

    // Driver Functionality


    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    });
});
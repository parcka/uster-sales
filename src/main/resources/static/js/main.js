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





})


// Stepper

$(document).ready(function () {


    var form = $("#signup-form");
    form.validate({
        errorPlacement: function errorPlacement(error, element) {
            element.before(error);
        },
        rules: {
            first_name: {
                required: true,
            },
            last_name: {
                required: true,
            },
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            first_name: {
                required: "Please enter your first name"
            },
            last_name: {
                required: "Please enter your last name"
            },
            email: {
                required: "Please enter your first name",
                email: "Please enter a valid email address!"
            }
        },
        onfocusout: function (element) {
            $(element).valid();
        },
        highlight: function (element, errorClass, validClass) {
            $(element).parent().parent().find('.form-group').addClass('form-error');
            $(element).removeClass('valid');
            $(element).addClass('error');
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parent().parent().find('.form-group').removeClass('form-error');
            $(element).removeClass('error');
            $(element).addClass('valid');
        }
    });
    form.steps({
        headerTag: "h3",
        bodyTag: "fieldset",
        transitionEffect: "fade",
        labels: {
            previous: 'Previous',
            next: 'Next',
            finish: 'Finish',
            current: ''
        },
        titleTemplate: '<h3 class="title">#title#</h3>',
        onInit: function (event, currentIndex) {
            console.log('onInit')
            // Suppress (skip) "Warning" step if the user is old enough.
            if (currentIndex === 0) {
                form.find('.actions').addClass('test');
            }

            // Datepicker

            $('#datepicker').datepicker({
                uiLibrary: 'bootstrap4'
            });

            // Datepicker


        },
        onStepChanging: function (event, currentIndex, newIndex) {
            console.log('onStepChanging')
            form.validate().settings.ignore = ":disabled,:hidden";
            return form.valid();
        },
        onFinishing: function (event, currentIndex) {
            console.log('onFinishing')
            form.validate().settings.ignore = ":disabled";
            return form.valid();
        },
        onFinished: function (event, currentIndex) {
            alert('Sumited');
        },
        onStepChanged: function (event, currentIndex, priorIndex) {
            console.log('onStepChanged')

        }
    });

    // jQuery.extend(jQuery.validator.messages, {
    //     required: "",
    //     remote: "",
    //     email: "",
    //     url: "",
    //     date: "",
    //     dateISO: "",
    //     number: "",
    //     digits: "",
    //     creditcard: "",
    //     equalTo: ""
    // });


})

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('.your_picture_image')
                .attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

// Stepper
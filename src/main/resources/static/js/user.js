
$(document).ready(function() {
    // Edit button click handler
    //$('table').DataTable();
    $('.edit-btn').click(function() {
        var userId = $(this).attr('id');
        // Populate the edit form with the user's information
        $('#edit-id').val(userId);
        $('#edit-first-name').val($('#user-' + userId + '-firstname').text());
        $('#edit-last-name').val($('#user-' + userId + '-lastname').text());
        $('#edit-email').val($('#user-' + userId + '-email').text());
        $('#edit-phone').val($('#user-' + userId + '-phone').text());
        $('#edit-status').val($('#user-' + userId + '-status').text());
        $('#edit-addr1').val($('#user-' + userId + '-addr1').text());
        $('#edit-addr2').val($('#user-' + userId + '-addr2').text());
        $('#edit-city').val($('#user-' + userId + '-city').text());
        $('#edit-state').val($('#user-' + userId + '-state').text());
        $('#edit-country').val($('#user-' + userId + '-country').text());
        $('#edit-zip').val($('#user-' + userId + '-zip').text());

        // Show the edit modal
        $('#edit-modal').modal('show');
    });

    // Edit form submit handler
    $('#edit-form').submit(function(e) {
        e.preventDefault();
        var userId = $('#edit-id').val();
        var firstName = $('#edit-first-name').val();
        var lastName = $('#edit-last-name').val();
        var email = $('#edit-email').val();
        var phone = $('#edit-phone').val();
        var status = $('#edit-status').val();
        var addr1 = $('#edit-addr1').val();
        var addr2 = $('#edit-addr2').val();
        var city = $('#edit-city').val();
        var state = $('#edit-state').val();
        var country = $('#edit-country').val();
        var zip = $('#edit-zip').val();

        console.log(userId);

        $.ajax({
            type: 'POST',
            url: '/account/updateUser',
            data:
                JSON.stringify({
                'id': userId,
                'firstname': firstName,
                'lastname': lastName,
                'email': email,
                'phone': phone,
                'status': status,
                'addr1': addr1,
                'addr2': addr2,
                'city': city,
                'state': state,
                'country': country,
                'zip': zip
            }),
            success: function(response) {
                // Update the user's information in the table

                $('#user-' + userId + '-firstname').text(firstName);
                $('#user-' + userId + '-lastname').text(lastName);
                $('#user-' + userId + '-email').text(email);
                $('#user-' + userId + '-phone').text(phone);
                $('#user-' + userId + '-status').text(status);
                $('#user-' + userId + '-addr1').text(addr1);

                $('#user-' + userId + '-addr2').text(addr2);
                $('#user-' + userId + '-city').text(city);
                $('#user-' + userId + '-state').text(state);
                $('#user-' + userId + '-country').text(country);
                $('#user-' + userId + '-zip').text(zip);
                // Hide the edit modal

                //$('#edit-form').hide();
                $('#edit-modal').modal('hide');
            },
            error: function(xhr) {
                alert(xhr.responseText);
            },
            dataType: "text",
            contentType: "application/json"
        });
    });

    console.log(123);
    var user_table = $('#user-table').DataTable({
        columns: [
            null,
            {"width":"20%"},
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            {"orderable" : false },
            {"orderable" : false}
        ]
    })
    console.log(456);

});


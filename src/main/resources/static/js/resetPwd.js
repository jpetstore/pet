
$(document).ready(function() {
    // Edit button click handler
    $(".resetPwd-btn").click(function() {
        var userId = $(this).attr('id');
        // Populate the edit form with the user's information
        $('#resetPwd-id').val(userId);
        // var ss = $('#resetPwd-first-name').val($('#user-' + userId + '-firstname').text());
        // $('#resetPwd-last-name').val($('#user-' + userId + '-lastname').text());
        // $('#resetPwd-email').val($('#user-' + userId + '-email').text());
        var ss = $('#resetPwd-new-password').val($('#user-' + userId + '-phone').text());
        // console.log(userId);
        // console.log(ss);
        // Show the edit modal
        $('#resetPwd-modal').modal('show');

    });

    $('#resetPwd-form').submit(function(e) {
        e.preventDefault();
        var userId = $('#resetPwd-id').val();
        var password=$('#resetPwd-new-password').val();
        console.log(userId);
        console.log(password);
        $.ajax({
            type: 'POST',
            url: '/account/resetPwd',
            data:
                JSON.stringify(
                    {
                        'id': userId,
                        'password':password
                    }),
            success: function(response) {
                $('#user-' + userId + '-password').text(CryptoJS.MD5(password+'tiege'));

                // Hide the edit modal
                $('#resetPwd-modal').modal('hide');
            },
            error: function(xhr) {
                alert(xhr.responseText);
            },
            dataType: "text",
            contentType: "application/json"
        });
    });
});


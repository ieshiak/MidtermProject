$(document).ready(function () {
    $('.rating').click(function () {
        var rating = $(this).data('rating');
        var artworkId = $(this).data('artwork-id');
        
        var baseUrl = window.location.origin;
        
        var url = baseUrl + '/createRating';

        $.ajax({
            type: 'POST',
            url: url,
            data: { rating: rating, artworkId: artworkId },
            success: function (response) {
                console.log(response);
            },
            error: function (xhr, status, error) {
                console.error(error);
            }
        });
    });
});

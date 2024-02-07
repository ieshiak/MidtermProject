document.addEventListener('DOMContentLoaded', function() {
    // Get all rating buttons
    const ratingButtons = document.querySelectorAll('.rating');

    // Loop through each button
    ratingButtons.forEach(function(button) {
        // Get the counter element next to the clicked button
        const counterElement = button.querySelector('span');

        // Get the artwork ID associated with this button
        const artworkId = button.getAttribute('data-artwork-id');

        console.log('Artwork ID:', artworkId);

        // Generate unique keys for localStorage
        const loveKey = `loveCounter_${artworkId}`;
        const likeKey = `likeCounter_${artworkId}`;
        const hateKey = `hateCounter_${artworkId}`;

        console.log('Love Key:', loveKey);
        console.log('Like Key:', likeKey);
        console.log('Hate Key:', hateKey);

        // Get the current counts from localStorage, or set them to 0 if not found
        let loveCount = parseInt(localStorage.getItem(loveKey)) || 0;
        let likeCount = parseInt(localStorage.getItem(likeKey)) || 0;
        let hateCount = parseInt(localStorage.getItem(hateKey)) || 0;

        console.log('Love Count:', loveCount);
        console.log('Like Count:', likeCount);
        console.log('Hate Count:', hateCount);

        // Update the counter elements with the stored counts
        document.getElementById(`loveCounter_${artworkId}`).textContent = loveCount;
        document.getElementById(`likeCounter_${artworkId}`).textContent = likeCount;
        document.getElementById(`hateCounter_${artworkId}`).textContent = hateCount;

        // Add click event listener to each button
        button.addEventListener('click', function() {
            // Increment the count based on the rating
            if (button.dataset.rating === 'Love') {
                loveCount++;
                localStorage.setItem(loveKey, loveCount);
                document.getElementById(`loveCounter_${artworkId}`).textContent = loveCount;
            } else if (button.dataset.rating === 'Like') {
                likeCount++;
                localStorage.setItem(likeKey, likeCount);
                document.getElementById(`likeCounter_${artworkId}`).textContent = likeCount;
            } else if (button.dataset.rating === 'Hate') {
                hateCount++;
                localStorage.setItem(hateKey, hateCount);
                document.getElementById(`hateCounter_${artworkId}`).textContent = hateCount;
            }

            console.log('Updated Counts:');
            console.log('Love Count:', loveCount);
            console.log('Like Count:', likeCount);
            console.log('Hate Count:', hateCount);
        });
    });
});

function navigateTo(page) {
    switch(page) {
        case 'jobPostingPage':
            window.location.href = '/jobPostingPage';
            break;
        case 'fairList':
            window.location.href = '/fairList';
            break;
        case 'jobRec':
            window.location.href = '/jobRec';
            break;
        case 'mainpage':
            window.location.href = '/mainpage';
            break;
        default:
            console.error('Unknown page: ' + page);
    }
}

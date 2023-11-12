window.onload = () => init();

const init = async function() {
    await request();
    setRequestInterval();
}

const setRequestInterval = function () {
    setInterval(() => request(), 5000);
}

const request = async function (){
    let isOff = false
    await $.get("/state/")
            .then(state => {
                if(!state){
                    $('.container').css('background', 'black');
                    $('.line-1').css('background', 'black');
                    $('.line-2').css('background', 'black');
                    $('.circle-bottom').css('background', 'black');
                    $('.container').css('opacity', '100')
                    isOff = true
                }
            });

    if (isOff) {
        return
    }

    await $.get("/color/current")
        .then((data) => {
            $('.container').css('background', `${data.color}`);
            $('.line-1').css('background', `${data.color}`);
            $('.line-2').css('background', `${data.color}`);
            $('.circle-bottom').css('background', `${data.color}`);
        });

    await $.get("/brightness/current")
        .then((data) => {
            $('.container').css('opacity', `${data / 100}`)
        });
}
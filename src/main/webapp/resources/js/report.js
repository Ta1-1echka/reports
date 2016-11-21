function dateFormat() {
    var index = document.getElementById("timePeriod").options.selectedIndex;
    var txt = document.getElementById("timePeriod").options[index].text;
    var date = new Date();
    var options = {month: "short", day: "numeric", year: "numeric"};
    var startDate, endDate;
    switch (txt) {
        case "Last Qtr":
            startDate = getDate(date.getMonth() - date.getMonth() % 3 - 3, 1);
            endDate = getDate(date.getMonth() - date.getMonth() % 3, 0);
            break;
        case "Last Month":
            startDate = getDate(date.getMonth() - 1, 1);
            endDate = getDate(date.getMonth(), 0);
            break;
        case "Last Calendar Year":
            startDate = getDate(date.getMonth() - 12 - date.getMonth(), 1);
            endDate = getDate(date.getMonth() - date.getMonth(), 0);
            break;
        case "Current Year to Date":
            startDate = getDate(date.getMonth() - date.getMonth(), 1);
            endDate = date;
            break;
        case "Current Qtr to Date":
            startDate = getDate(date.getMonth() - date.getMonth() % 3, 1);
            endDate = date;
            break;
        case "Current Month to Date":
            startDate = getDate(date.getMonth(), 1);
            endDate = date;
            break;
        default:
            startDate = "";
            endDate = "";
            break;
    }
    if (startDate == "" & endDate == "") {
        document.getElementById("startDate").value = "";
        document.getElementById("endDate").value = "";
    }
    else {
        document.getElementById("startDate").value = startDate.toLocaleDateString("en-us", options);
        document.getElementById("endDate").value = endDate.toLocaleDateString("en-us", options);
    }

}

function getDate(date, i) {
    return new Date(new Date().setMonth(date, i));
}

function checkDate() {
    var txt1 = document.getElementById("startDate").value;
    var txt2 = document.getElementById("endDate").value;
    var pattern = new RegExp("[^-][1-9]{1}[0-9]{0,1}(,)");
    var txt = '';
    if ((isNaN(Date.parse(txt1)) || !pattern.exec(txt1)) & txt1 != '') {
        txt += "Error. Check value in the 'start date'.";
    }

    if ((isNaN(Date.parse(txt2)) || !pattern.exec(txt2)) & txt2 != '') {
        txt += "Error. Check value in the 'end date'.";
    }

    if (!isNaN(Date.parse(txt1)) & !isNaN(Date.parse(txt2)) & Date.parse(txt2) < Date.parse(txt1)) {
        txt += "The end date should be over the start date";
    }
    document.getElementById("message").innerText = txt;

}

function setPerformer() {
    var index = document.getElementById("performer").options.selectedIndex;
    var txt = document.getElementById("performer").options[index].text;
    document.getElementById("hiddenPerformer").value = txt;
}
function setHiddenDate() {
    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;
    var options = {month: "numeric", day: "numeric", year: "numeric"};
    var ss;
    if (startDate.length != 0) {
        var newStartDate = new Date(Date.parse(startDate) + 1).toLocaleDateString("en-us", options);
        ss = newStartDate.split("/");
        startDate = '';
        startDate = ss[2] + '-' + ss[0] + '-' + ss[1];
        document.getElementById("hiddenStartDate").value = startDate;
    }
    if (endDate.length != 0) {
        var newEndDate = new Date(Date.parse(endDate) + 1).toLocaleDateString("en-us", options);
        ss = newEndDate.split("/");
        endDate = ss[2] + '-' + ss[0] + '-' + ss[1];
        document.getElementById("hiddenEndDate").value = endDate;
    }

}

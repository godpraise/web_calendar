window.onload = function() {
    var urlParams = new URLSearchParams(window.location.search);
    var date = urlParams.get('date');

    var [day, month, year] = date.split(" ");
    var rearrangedDate = `${year} ${month} ${day}`;

    document.getElementById("dateTitle").innerText = rearrangedDate;

    var timeTable = document.getElementById("timeTable");
    for(var i = 0; i < 24; i++) {
        var row = document.createElement("tr");
        row.id = `row${i}`;

        var timeSlot = document.createElement("td");
        timeSlot.classList.add("timeSlot");
        timeSlot.innerText = (i < 12 ? `오전 ${i}시` : (i === 12 ? "오후 12시" : `오후 ${i - 12}시`));
        row.appendChild(timeSlot);

        var eventSlot = document.createElement("td");
        eventSlot.classList.add("eventSlot");
        eventSlot.onclick = function() {
            var event = this.dataset.event;
            if (event) {
                showEvent(JSON.parse(event));
            } else {
                showEventForm(this.parentElement.id);
            }
        };
        row.appendChild(eventSlot);

        timeTable.appendChild(row);
    }
};

var selectedEventSlot = null;
function showEventForm(rowId) {
    var eventFormWrapper = document.getElementById("eventFormWrapper");
    eventFormWrapper.style.display = "block";

    var eventDisplay = document.getElementById("eventDisplay");
    eventDisplay.style.display = "none";
}

document.getElementById("addEventButton").addEventListener("click", function() {
    showEventForm();
});

function addEvent() {
    var eventFormWrapper = document.getElementById("eventFormWrapper");
    var startRowId = parseInt(eventFormWrapper.dataset.rowId.slice(3));
    var endRowId = document.getElementById("endTime").value;
    var eventTitle = document.getElementById("eventTitle").value;
    var eventContent = document.getElementById("eventContent").value;

    for (var i = startRowId; i <= endRowId; i++) {
        var eventSlot = document.getElementById(`row${i}`).getElementsByClassName("eventSlot")[0];
        eventSlot.textContent = eventTitle;
        eventSlot.dataset.event = JSON.stringify({ title: eventTitle, content: eventContent });
    }

    resetForm();
}

function resetForm() {
    var eventFormWrapper = document.getElementById("eventFormWrapper");
    eventFormWrapper.style.display = "none";
    document.getElementById("eventTitle").value = "";
    document.getElementById("eventContent").value = "";
    document.getElementById("startTime").value = "";
    document.getElementById("endTime").value = "";
}

function deleteEvent() {
    if (selectedEventSlot) {
        selectedEventSlot.textContent = "";
        selectedEventSlot.dataset.event = "";

        var eventDisplay = document.getElementById("eventDisplay");
        eventDisplay.style.display = "none";
    }
}

function showEvent(event) {
    var eventDisplay = document.getElementById("eventDisplay");
    document.getElementById("eventDisplayTitle").textContent = event.title;
    document.getElementById("eventDisplayContent").textContent = event.content;
    eventDisplay.style.display = "block";

    var eventFormWrapper = document.getElementById("eventFormWrapper");
    eventFormWrapper.style.display = "none";
}

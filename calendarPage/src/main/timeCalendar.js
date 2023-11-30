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

    var modal = document.getElementById("myModal");
    var btn = document.getElementById("addEventButton");
    var span = document.getElementsByClassName("close")[0];
    var spanForm = document.querySelector("#eventForm .close");

    spanForm.onclick = function() {
        modal.style.display = "none";
    }

    btn.onclick = function() {
        modal.style.display = "block";
    }

    span.onclick = function() {
        modal.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }

    document.getElementById("editEventButton").addEventListener("click", function() {
        showEventList();
    });
};

function showEventList() {
    var eventListWrapper = document.getElementById("eventListWrapper");
    eventListWrapper.innerHTML = ""; // 이전에 표시된 목록을 초기화

    var events = {};

    for(var i = 0; i < 24; i++) {
        var eventSlot = document.getElementById(`row${i}`).getElementsByClassName("eventSlot")[0];
        var event = eventSlot.dataset.event;
        if (event) {
            event = JSON.parse(event);
            var eventDuration = event.endTime - event.startTime;
            if (events[event.title]) {
                events[event.title] += eventDuration; // 같은 제목의 이벤트가 이미 있으면 시간을 더함
            } else {
                events[event.title] = eventDuration; // 같은 제목의 이벤트가 없으면 새로 추가
            }
        }
    }

    for (var title in events) {
        var eventItem = document.createElement("div");
        eventItem.innerHTML = `제목: ${title}, 시간: ${events[title]}시간`; // 제목 옆에 총 시간을 표시
        eventListWrapper.appendChild(eventItem);
    }


    eventListWrapper.style.display = "block"; // 일정 목록을 보이게 함
}

function showEventForm() {
    var eventFormWrapper = document.getElementById("eventFormWrapper");
    eventFormWrapper.style.display = "block";

    var eventDisplay = document.getElementById("eventDisplay");
    eventDisplay.style.display = "none";

    var modal = document.getElementById("myModal");
    modal.style.display = "none";
}

document.getElementById("addEventButton").addEventListener("click", function() {
    showEventForm();
});

function addEvent() {
    var startRowId = parseInt(document.getElementById("startTime").value);
    var endRowId = parseInt(document.getElementById("endTime").value);
    var eventTitle = document.getElementById("eventTitle").value;
    var eventContent = document.getElementById("eventContent").value;

    for (var i = startRowId; i <= endRowId; i++) {
        var eventSlot = document.getElementById(`row${i}`).getElementsByClassName("eventSlot")[0];
        eventSlot.textContent = eventTitle;
        eventSlot.dataset.event = JSON.stringify({ title: eventTitle, content: eventContent });
    }

    resetForm();
    var modal = document.getElementById("myModal");
    modal.style.display = "none";
}

function resetForm() {
    var eventFormWrapper = document.getElementById("eventFormWrapper");
    eventFormWrapper.style.display = "none";
    document.getElementById("eventTitle").value = "";
    document.getElementById("eventContent").value = "";
    document.getElementById("startTime").value = "";
    document.getElementById("endTime").value = "";
}

/*function deleteEvent() {
    if (selectedEventSlot) {
        selectedEventSlot.textContent = "";
        selectedEventSlot.dataset.event = "";

        var eventDisplay = document.getElementById("eventDisplay");
        eventDisplay.style.display = "none";
    }
}*/

function showEvent(event) {
    var eventDisplay = document.getElementById("eventDisplay");
    document.getElementById("eventDisplayTitle").textContent = event.title;
    document.getElementById("eventDisplayContent").textContent = event.content;
    eventDisplay.style.display = "block";

    var eventFormWrapper = document.getElementById("eventFormWrapper");
    eventFormWrapper.style.display = "none";
}

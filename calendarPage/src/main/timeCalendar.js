window.onload = function() {
    // URL에서 날짜 정보를 가져옵니다.
    var urlParams = new URLSearchParams(window.location.search);
    var date = urlParams.get('date');

    // 년도, 월, 일로 분리
    var [day, month, year] = date.split(" ");
    // 년도, 월, 일 순으로 재배열
    var rearrangedDate = `${year} ${month} ${day}`;

    // 날짜 제목을 설정합니다.
    document.getElementById("dateTitle").innerText = rearrangedDate;

    // 시간별 캘린더를 생성합니다.
    var timeTable = document.getElementById("timeTable");
    for(var i = 0; i < 24; i++) {
        var row = document.createElement("tr");

        var timeSlot = document.createElement("td");
        timeSlot.classList.add("timeSlot");
        timeSlot.innerText = (i < 12 ? `오전 ${i}시` : (i == 12 ? "오후 12시" : `오후 ${i - 12}시`));
        row.appendChild(timeSlot);

        var eventSlot = document.createElement("td");
        eventSlot.classList.add("eventSlot");
        // 이벤트 슬롯은 초기에 빈 상태입니다.
        row.appendChild(eventSlot);

        timeTable.appendChild(row);
    }
};
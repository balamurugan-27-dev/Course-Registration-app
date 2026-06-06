function showcourse(){
    fetch("http://localhost:8080/course/list").then((response)=>response.json())
    .then((courses)=>{
        const dataTable=document.getElementById("courseTable");
        courses.forEach(element => {
            var row= `<tr>
                <td>${element.id}</td>
                <td>${element.CourseName}</td>
                <td>${element.Trainer}</td>
                <td>${element.durationInWeek}</td>
            </tr>`

            dataTable.innerHTML+=row;

        });
    })
}

function Showstudent(){
    fetch("http://localhost:8080/course/enrolled").then((response)=>response.json())
    .then((students)=>{
        const studentData=document.getElementById("enrolledtable");
        students.forEach(element=>{
            var row=`<tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.email}</td>
                <td>${element.course}</td>

            </tr>`

            studentData.innerHTML+=row;

        })
    })
}
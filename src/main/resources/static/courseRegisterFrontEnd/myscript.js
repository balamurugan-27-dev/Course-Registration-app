function showcourse(){
    fetch("http://localhost:8080/user/list").then((response)=>response.json())
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
    fetch("http://localhost:8080/user/enrolled").then((response)=>response.json())
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

function addCourse(){
    let data ={
        CourseName:document.getElementById("inputCourseName").value,
        Trainer:document.getElementById("inputTrainerName").value,
        durationInWeek:document.getElementById("inputDuration").value   
    };
    let jsonData=JSON.stringify(data);
    fetch("http://localhost:8080/admin/addcourse",{
        method:"Post",
        headers:{
         "Content-Type":"application/json"
        },
        body:jsonData
    }).then(response=>response.text()).then(data=>(document.getElementById("status").innerText=data))
    .catch(error=>console.error(error));

}

function deleteCourse(){
    let data=document.getElementById("inputid").value;
    

    fetch(`http://localhost:8080/admin/deletecourse?id=${data}`,
        {
            method:"Delete",
            headers:{
                "Content-Type":"application/json"
            },

        }
    ).then(response=>response.text()).then(data=>(document.getElementById("status").innerText=data))
    .catch(error=>console.error(error));
}
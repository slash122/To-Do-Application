import React from "react";

function Form({addTaskCallback}) {
    
    function addTask() {
        let taskText = document.getElementById("taskText").value;
        addTaskCallback(taskText);
    }
    
    return (
        <div>
        <label>
            Name:
            <input type="text" id="taskText" />
        </label>
        <button onClick={addTask}>Add task</button>
        </div>
    );
}

export default Form;
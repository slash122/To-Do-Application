import React from "react";

function Task({task, deleteTaskCallback}) {
    
    function deleteTask() {
        deleteTaskCallback(task.id);
    }
    
    return (
        <div className="task">
            <div>{task.text}</div>
            <button onClick={deleteTask}>Delete</button>
        </div> 
    );
}

export default Task;
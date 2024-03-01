
import './App.css';
import { useEffect, useState } from 'react';
import Form from './Form';
import Task from './Task';


function App() {
  const [tasks, setTasks] = useState([]);

  function addTaskCallback(taskText) {
    fetch('http://localhost:8080/tasks', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({text: taskText}),
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      fetch('http://localhost:8080/tasks')
      .then(response => response.json())
      .then((data) => {setTasks(data);
        console.log(data);});
    })
    .catch(error => {
      // Handle error
      console.error('There was a problem with your fetch operation:', error);
    });

    // setTasks([...tasks, {text: taskText}]);
  }

  function deleteTaskCallback(id) {
    // console.log("AASDASDASD");
    
    fetch('http://localhost:8080/tasks/' + id, {
      method: 'DELETE',
    })
    .then(response => {
      if (response.ok) {
        fetch('http://localhost:8080/tasks')
        .then(response => response.json())
        .then(data => setTasks(data));
      }
      
      // if (!response.ok) {
      //   throw new Error('Network response was not ok');
      // }
      // return response.json();
    })
    // .then(data => {
    //   fetch('http://localhost:8080/tasks')
    //   .then(response => response.json())
    //   .then(data => setTasks(data));
    // })
    // .catch(error => {
    //   // Handle error
    //   console.error('There was a problem with your fetch operation:', error);
    // });
  }

  useEffect(() => {
    fetch('http://localhost:8080/tasks')
      .then(response => response.json())
      .then(data => setTasks(data));
  }, []);

  tasks.forEach(task => console.log(task));

  return (
    <div className='body'>
      <Form addTaskCallback={addTaskCallback}/>
        {tasks.map(task => <Task key={task.id} task={task} deleteTaskCallback={deleteTaskCallback}/>)}
    </div>
  );
}

export default App;

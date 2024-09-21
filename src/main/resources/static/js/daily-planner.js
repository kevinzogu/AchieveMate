document.getElementById('add-task-btn').addEventListener('click', function() {
    const taskList = document.getElementById('task-list');
    const newTask = document.createElement('li');

    newTask.innerHTML = `
        <input type="text" class="task-text" placeholder="Shkruaj detyrën" />
        <input type="checkbox" class="task-done" />
    `;

    taskList.appendChild(newTask);
});

// Funksioni për të krijuar dhe menaxhuar ikonat e gotave të ujit
document.getElementById('water-cups').addEventListener('input', function() {
    const waterContainer = document.getElementById('water-icons');
    waterContainer.innerHTML = ''; // Pastron ikonat ekzistuese

    const cups = parseInt(this.value);
    for (let i = 0; i < cups; i++) {
        const waterIcon = document.createElement('img');
        // URL e ikonës së gotës nga https://icons8.com
        waterIcon.src = "https://img.icons8.com/ios-filled/50/000000/water.png";
        waterContainer.appendChild(waterIcon);
    }
});

// Funksioni për të krijuar dhe menaxhuar ikonat e hënave për orët e gjumit
document.getElementById('sleep-hours').addEventListener('input', function() {
    const sleepContainer = document.getElementById('sleep-icons');
    sleepContainer.innerHTML = ''; // Pastron ikonat ekzistuese

    const hours = parseInt(this.value);
    for (let i = 0; i < hours; i++) {
        const moonIcon = document.createElement('img');
        moonIcon.src = 'https://img.icons8.com/ios-filled/50/000000/moon-symbol.png'; // URL e ikonës së hënës
        sleepContainer.appendChild(moonIcon);
    }
});

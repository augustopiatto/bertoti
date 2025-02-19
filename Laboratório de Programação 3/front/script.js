const button = document.getElementById('button')

button.addEventListener('click', async function () {
    let data = []
    try {
        button.disabled = true

        const response = await fetch('http://localhost:8080/coffees')
        data = await response.json()
    } catch (error) {
        console.error('Erro ao buscar dados:', error)
        button.disabled = false
    }

    const container = document.getElementById('container')

    data.forEach((coffee) => {
        const coffeeItem = document.createElement('div')
        coffeeItem.classList.add('coffee-item')

        const idSpan = document.createElement('span')
        idSpan.textContent = `ID: ${coffee.id}`

        const nameSpan = document.createElement('span')
        nameSpan.textContent = coffee.name

        coffeeItem.appendChild(idSpan)
        coffeeItem.appendChild(nameSpan)
        container.appendChild(coffeeItem)
    })
})

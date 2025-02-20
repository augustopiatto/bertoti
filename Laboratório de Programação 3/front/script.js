const listButton = document.getElementById("list-button");
const createButton = document.getElementById("create-button");
const editButton = document.getElementById("edit-button");
const deleteButton = document.getElementById("delete-button");

const listTab = document.getElementById("list-tab");
const createTab = document.getElementById("create-tab");
const editTab = document.getElementById("edit-tab");
const deleteTab = document.getElementById("delete-tab");

const listContent = document.getElementById("list-content");
const createBrand = document.getElementById("create-brand");
const createFlavor = document.getElementById("create-flavor");
const createValidity = document.getElementById("create-validity");
const createSubmit = document.getElementById("create-submit");

const editSelect = document.getElementById("edit-select");
const editBrand = document.getElementById("edit-brand");
const editFlavor = document.getElementById("edit-flavor");
const editValidity = document.getElementById("edit-validity");
const editSubmit = document.getElementById("edit-submit");

const deleteSelect = document.getElementById("delete-select");
const deleteSubmit = document.getElementById("delete-submit");

let cookies = [];

function closeAllTabs() {
  listTab.classList.remove("active");
  createTab.classList.remove("active");
  editTab.classList.remove("active");
  deleteTab.classList.remove("active");
}

function disableCurrentButton(button) {
  listButton.disabled = false;
  createButton.disabled = false;
  editButton.disabled = false;
  deleteButton.disabled = false;
  button.disabled = true;
}

async function listCookies() {
  try {
    const response = await fetch("http://localhost:8080/bolachas");
    cookies = await response.json();
    listContent.innerHTML = "";
    cookies.forEach((cookie) => {
      const item = document.createElement("div");
      item.classList.add("bolacha-item");

      const info = document.createElement("div");
      info.classList.add("bolacha-info");
      info.innerHTML = `
      <strong>${cookie.marca}</strong>
      <span>Sabor: ${cookie.sabor}</span>
      <span>Validade: ${cookie.validade}</span>
    `;

      item.appendChild(info);
      listContent.appendChild(item);
    });
  } catch (error) {
    console.error("Erro ao buscar dados:", error);
  }
}

listButton.addEventListener("click", async function () {
  closeAllTabs();
  listTab.classList.add("active");
  disableCurrentButton(listButton);

  await listCookies();
});

createButton.addEventListener("click", function () {
  closeAllTabs();
  createTab.classList.add("active");
  disableCurrentButton(createButton);
});

createSubmit.addEventListener("click", async function () {
  const newCookie = {
    sabor: createBrand.value,
    marca: createFlavor.value,
    validade: createValidity.value,
  };

  try {
    const response = await fetch("http://localhost:8080/bolachas", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newCookie),
    });
    const data = await response.json();
    cookies.push(data);
    createBrand.value = "";
    createFlavor.value = "";
    createValidity.value = "";
    alert("Bolacha criada com sucesso!");
  } catch (error) {
    console.error("Erro ao criar bolacha:", error);
  }
});

editButton.addEventListener("click", async function () {
  closeAllTabs();
  editTab.classList.add("active");
  disableCurrentButton(editButton);
  editSelect.innerHTML = "";
  await listCookies();
  cookies.forEach((cookie) => {
    const option = document.createElement("option");
    option.value = cookie.id;
    option.textContent = `ID: ${cookie.id}, Marca: ${cookie.marca}`;
    editSelect.appendChild(option);
  });
});

editSubmit.addEventListener("click", async function () {
  const selectedCookieId = editSelect.value;
  const updatedCookie = {
    marca: editBrand.value,
    sabor: editFlavor.value,
    validade: editValidity.value,
  };

  try {
    const response = await fetch(
      `http://localhost:8080/bolachas/${selectedCookieId}`,
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedCookie),
      }
    );
    const data = await response.json();
    const index = cookies.findIndex((cookie) => cookie.id === selectedCookieId);
    cookies[index] = data;
    alert("Bolacha editada com sucesso!");
  } catch (error) {
    console.error("Erro ao editar bolacha:", error);
  }
});

deleteButton.addEventListener("click", async function () {
  closeAllTabs();
  deleteTab.classList.add("active");
  disableCurrentButton(deleteButton);
  deleteSelect.innerHTML = "";
  await listCookies();
  cookies.forEach((cookie) => {
    const option = document.createElement("option");
    option.value = cookie.id;
    option.textContent = `ID: ${cookie.id}, Marca: ${cookie.marca}`;
    deleteSelect.appendChild(option);
  });
});

deleteSubmit.addEventListener("click", async function () {
  const selectedCookieId = deleteSelect.value;

  try {
    await fetch(`http://localhost:8080/bolachas/${selectedCookieId}`, {
      method: "DELETE",
    });
    cookies = cookies.filter((cookie) => cookie.id !== selectedCookieId);
    alert("Bolacha deletada com sucesso!");
  } catch (error) {
    console.error("Erro ao deletar bolacha:", error);
  }
});

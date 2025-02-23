const listButton = document.getElementById("list-button");
const listTab = document.getElementById("list-tab");
const listContent = document.getElementById("list-content");

let cookies = [];

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
  await listCookies();
});

let carrinho = [];

function buscarProdutos() {
    const query = document.getElementById('busca').value;
    fetch('/produtos') // Ajuste para o endpoint do servlet
        .then(response => response.json())
        .then(produtos => {
            const container = document.getElementById('produtos');
            container.innerHTML = '';
            produtos.filter(p => p.nome.toLowerCase().includes(query.toLowerCase())).forEach(p => {
                const div = document.createElement('div');
                div.className = 'produto';
                div.innerHTML = `<h3>${p.nome}</h3><p>${p.descricao}</p><p>R$ ${p.preco}</p><button onclick="adicionarAoCarrinho(${p.id}, '${p.nome}', ${p.preco})">Adicionar ao Carrinho</button>`;
                container.appendChild(div);
            });
        });
}

function adicionarAoCarrinho(id, nome, preco) {
    carrinho.push({ id, nome, preco });
    atualizarCarrinho();
}

function atualizarCarrinho() {
    const lista = document.getElementById('itens-carrinho');
    lista.innerHTML = '';
    carrinho.forEach(item => {
        const li = document.createElement('li');
        li.textContent = `${item.nome} - R$ ${item.preco}`;
        lista.appendChild(li);
    });
}

function finalizarCompra() {
    alert('Compra finalizada! (Simulação)');
    carrinho = [];
    atualizarCarrinho();
}

// Carregar produtos ao iniciar
window.onload = buscarProdutos;
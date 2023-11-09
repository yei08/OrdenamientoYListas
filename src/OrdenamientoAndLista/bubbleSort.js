function bubbleSort(lista) {
    const n = lista.length;
    let intercambiado;
  
    do {
      intercambiado = false;
  
      for (let i = 1; i < n; i++) {
        if (lista[i - 1] > lista[i]) {
          [lista[i - 1], lista[i]] = [lista[i], lista[i - 1]];
          intercambiado = true;
        }
      }
    } while (intercambiado);
  }
  
  function desordenar(lista) {
    const n = lista.length;
    for (let i = 0; i < n; i++) {
      const indiceAleatorio = Math.floor(Math.random() * n);
      [lista[i], lista[indiceAleatorio]] = [lista[indiceAleatorio], lista[i]];
    }
  }
  
  // Ejemplo de uso
  const lista = [5, 2, 9, 3, 1, 6, 8, 7, 4];
  console.log("Lista original:", lista);
  
  bubbleSort(lista);
  console.log("Lista ordenada:", lista);
  
  desordenar(lista);
  console.log("Lista desordenada:", lista);
  
import random

def bubble_sort(lista):
    n = len(lista)
    intercambiado = True

    while intercambiado:
        intercambiado = False

        for i in range(1, n):
            if lista[i - 1] > lista[i]:
                lista[i - 1], lista[i] = lista[i], lista[i - 1]
                intercambiado = True

def desordenar(lista):
    n = len(lista)
    for i in range(n):
        indice_aleatorio = random.randint(0, n - 1)
        lista[i], lista[indice_aleatorio] = lista[indice_aleatorio], lista[i]

# Ejemplo de uso
if __name__ == '__main__':
    lista = [5, 2, 9, 3, 1, 6, 8, 7, 4]
    print("Lista original:", lista)

    bubble_sort(lista)
    print("Lista ordenada:", lista)

    desordenar(lista)
    print("Lista desordenada:", lista)

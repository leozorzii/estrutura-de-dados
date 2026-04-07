from collections import deque

fila_normal = deque()
fila_prioritaria = deque()

class FichaAtendimento:
    
    @staticmethod
    def gera_ficha_Normal(fila_normal, contador_normal):
        print("Imprimindo ficha normal...")
        print(contador_normal)
        fila_normal.append(contador_normal)
        contador_normal += 1
        return contador_normal

    @staticmethod
    def gera_ficha_prioritaria(fila_prioritaria, contador_prioritaria):
        print("Imprimindo ficha prioritaria...")
        print(contador_prioritaria)
        fila_prioritaria.append(contador_prioritaria)
        contador_prioritaria += 1
        return contador_prioritaria
   

    @staticmethod
    def gera_atendimento(fila_normal, fila_prioritaria, contador_atendimentos):
        if not fila_normal and not fila_prioritaria:
            print("Nao ha fichas para chamar...")
            return contador_atendimentos
            
        if contador_atendimentos % 3 == 0 or not fila_normal:
            if fila_prioritaria:
                ficha = fila_prioritaria.popleft()
                print("Prioritaria: " + str(ficha))
                contador_atendimentos +=1 
                return contador_atendimentos
                    
        if fila_normal:
            ficha = fila_normal.popleft()
            print("Normal: " + str(ficha))
            contador_atendimentos +=1
            
        return contador_atendimentos
    
    @staticmethod
    def mostrar_fichas_faltantes(fila_normal, fila_prioritaria):
        if not fila_normal and not fila_prioritaria:
            print("nao ha fichas para chamar")
            return
        if fila_normal:
            print(f"total de fichas faltantes normais: {len(fila_normal)} - {list(fila_normal)}")
            
        if fila_prioritaria:
            print(f"total de fichas faltantes prioritarias: {len(fila_prioritaria)} - {list(fila_prioritaria)}")                        

    @staticmethod
    def menu(fila_normal, fila_prioritaria):
        contador_prioritaria = 501
        contador_normal = 1
        contador_atendimentos = 0
        while True: 
            opcao = ""
            print("M E N U")
            print("1 - Ficha Normal")
            print("2 - Ficha Prioritaria")
            print("3 - Chamar Ficha")
            print("4 - Mostrar Fichas faltantes")
            print(" 5 - Sair")
            opcao = input("Opcao: ")
            if opcao == "1":
                contador_normal = FichaAtendimento.gera_ficha_Normal(fila_normal, contador_normal)
            elif opcao == "2":
                contador_prioritaria = FichaAtendimento.gera_ficha_prioritaria(fila_prioritaria, contador_prioritaria)    
            elif opcao == "3":
                contador_atendimentos = FichaAtendimento.gera_atendimento(fila_normal, fila_prioritaria, contador_atendimentos)
            elif opcao == "4":
                FichaAtendimento.mostrar_fichas_faltantes(fila_normal, fila_prioritaria)    
            elif opcao == "5":
                print("Saindo...")
                break
            else:
                print("opcao invalida!")


if __name__ == "__main__":
     
     FichaAtendimento.menu(fila_normal, fila_prioritaria)
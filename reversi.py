from graphicalBoard import GraphicWindow
from threading import Thread
from queue import Queue
from array2d import Array2D
from random import randint

def askplayer(id):
    """
    DO NOT CHANGE THIS FUNCTION
    Ask for the nature of a player
    :param id: "rouge" or "bleu"
    :return:  'h' for a human player, 'I' for an IA player
    """
    res = ''
    while res != 'h' and res != 'I':
        res = input('Le joueur ' + str(id) + ' est-il (h)umain ou (I)A ? ')
        if res != 'h' and res != 'I':
            print('Il faut répondre h ou I, merci.')
    return res

"""

    La fonction compte va compter le nombre de points que peut lui rapporter la pose d'un pion sur une case jouable
    elle est utilisée pour l'ia avancée
    compte va ensuite retourner une liste contenant la position dont le nombre de points est le plus elevé 

"""
def compte(nbcols, nbrows, board, gw, joueur):
    posOptimal = [-1,0,0]
    posMax = [-1,-1,-1]
    if joueur == 'blue' :
        advers = 'red'
    elif joueur == 'red':
        advers = 'blue'
    for i in range(nbcols):
        for j in range(nbrows):
            if(board.getvalue(i,j) != 0):
                if(board.getvalue(i,j) == 'posPo'):
                    posOptimal[0] = i
                    posOptimal[1] = j
                    posOptimal[2] = compteDroite(board, i, j, advers, joueur) + compteGauche(board, i, j, advers, joueur) + compteHaut(board, i, j, advers, joueur) + compteBas(board, i, j, advers, joueur) + compteDiagoDB(board, i, j, advers, joueur) + compteDiagoDH(board, i, j, advers, joueur) + compteDiagoGH(board, i, j, advers, joueur) + compteDiagoGB(board, i, j, advers, joueur)
                    if(posOptimal[2] > posMax[2]):
                        posMax[0] = posOptimal[0]
                        posMax[1] = posOptimal[1]
                        posMax[2] = posOptimal[2]
    return posMax
        
def compteDiagoDB(board, i, j, valEntre, valJoueur):
    count = 0
    if(j<=0 or j>=7 or i<=0 or i >=7):
        return 0
    if(board.getvalue(i+1,j+1) == valEntre):
        while(j<7 and i<7):
            if(board.getvalue(i+1, j+1) == valEntre):
                count=count+1
            elif(board.getvalue(i+1,j+1) == valJoueur):
                return count
            i=i+1
            j=j+1
    return 0

def compteDiagoDH(board, i, j, valEntre, valJoueur):
    count = 0
    if(j<=0 or j>=7 or i<=0 or i >=7):
        return 0
    if(board.getvalue(i-1,j+1) == valEntre):
        while(j<7 and i>0):
            if(board.getvalue(i-1, j+1) == valEntre):
                count=count+1
            elif(board.getvalue(i-1,j+1) == valJoueur):
                return count
            i=i-1
            j=j+1
    return 0

def compteDiagoGH(board, i, j, valEntre, valJoueur):
    count = 0
    if(j<=0 or j>=7 or i<=0 or i >=7):
        return 0
    if(board.getvalue(i-1,j-1) == valEntre):
        while(j>0 and i>0):
            if(board.getvalue(i-1, j-1) == valEntre):
                count=count+1
            elif(board.getvalue(i-1,j-1) == valJoueur):
                return count
            i=i-1
            j=j-1
    return 0

def compteDiagoGB(board, i, j, valEntre, valJoueur):
    count = 0
    if(j<=0 or j>=7 or i<=0 or i >=7):
        return 0
    if(board.getvalue(i+1,j-1) == valEntre):
        while(j>0 and i>7):
            if(board.getvalue(i+1, j-1) == valEntre):
                count=count+1
            elif(board.getvalue(i+1,j-1) == valJoueur):
                return count
            i=i+1
            j=j-1
    return 0
                
def compteDroite(board, i, j, valEntre, valJoueur):
    count = 0
    if(j>=7):
        return 0
    if(board.getvalue(i,j+1) == valEntre):
        while(j<7):
            j=j+1
            if(board.getvalue(i,j) == valEntre):
                count = count + 1
            elif(board.getvalue(i,j) == valJoueur):
                return count
    return 0

def compteGauche(board, i, j, valEntre, valJoueur):
    count = 0
    if(j<=0):
        return 0
    if(board.getvalue(i,j-1) == valEntre):
        while(j>0):
            j=j-1
            if(board.getvalue(i,j) == valEntre):
                count = count + 1
            elif(board.getvalue(i,j) == valJoueur):
                return count
    return 0

def compteHaut(board, i, j, valEntre, valJoueur):
    count = 0
    if(i<=0):
        return 0
    if(board.getvalue(i-1,j) == valEntre):
        while(i>0):
            i=i-1
            if(board.getvalue(i,j) == valEntre):
                count = count + 1
            elif(board.getvalue(i,j) == valJoueur):
                return count
    return 0

def compteBas(board, i, j, valEntre, valJoueur):
    count = 0
    if(i>=7):
        return 0
    if(board.getvalue(i+1,j) == valEntre):
        while(i<7):
            i=i+1
            if(board.getvalue(i,j) == valEntre):
                count = count + 1
            elif(board.getvalue(i,j) == valJoueur):
                return count
    return 0

"""

    cleanTable enlève chaque carré jaune dessiné sur le board

"""

def cleanTable(nbcols, nbrows, board, gw):
    for i in range(nbcols):
        for j in range(nbrows):
            if(board.getvalue(i,j) == 'posPo'):
                board.setvalue(i,j,0)
                gw.drawwhitesquare(i,j)


"""

cette fonction va verifier les zones ou le joueur pourra poser un pion

"""
def chercheZoneJouable(nbcols, nbrows, board,gw,joueur):
    advers = ''
    if joueur == 'blue' :
        advers = 'red'
    elif joueur == 'red':
        advers = 'blue'
        
    for i in range(nbcols):
        for j in range(nbrows):
            if(board.getvalue(i,j) != 0):
                if(board.getvalue(i,j) == joueur):
                    posPoDroite(board, gw, i, j, advers, joueur)
                    posPoGauche(board, gw, i, j, advers, joueur)
                    posPoHaut(board, gw, i, j, advers, joueur)
                    posPoBas(board, gw, i, j, advers, joueur)
                    posPoDiagoDroiteBas(board, gw, i, j, advers, joueur)
                    posPoDiagoGaucheBas(board, gw, i, j, advers, joueur)
                    posPoDiagoGaucheHaut(board, gw, i, j, advers, joueur)
                    posPoDiagoDroiteHaut(board, gw, i, j, advers, joueur)
                    
def posPoDiagoDroiteBas(board, gw, i, j, valEntre, valJoueur):
    if(j<=0 or j>=7 or i<=0 or i >=7):
        return 0
    if(board.getvalue(i+1,j+1) == valEntre):
        while(j<7 and i<7):
            if(board.getvalue(i+1, j+1) == 0 or board.getvalue(i+1, j+1) == 'posPo'):
                gw.drawyellowsquare(i+1, j+1)
                board.setvalue(i+1,j+1,'posPo')
                break
            if(board.getvalue(i+1,j+1) == valJoueur):
                break
            j=j+1
            i=i+1
            
def posPoDiagoDroiteHaut(board, gw, i, j, valEntre, valJoueur):
    if(j<=0 or j>=7 or i<=0 or i >=7):
        return 0
    if(board.getvalue(i-1,j+1) == valEntre):
        while(j<7 and i>0):
            if(board.getvalue(i-1, j+1) == 0 or board.getvalue(i-1, j+1) == 'posPo'):
                gw.drawyellowsquare(i-1, j+1)
                board.setvalue(i-1,j+1,'posPo')
                break
            if(board.getvalue(i-1,j+1) == valJoueur):
                break
            j=j+1
            i=i-1
            
def posPoDiagoGaucheBas(board, gw, i, j, valEntre, valJoueur):
    if(j<=0 or j>=7 or i<=0 or i >=7):
        return 0
    if(board.getvalue(i+1,j-1) == valEntre):
        while(j>0 and i<7):
            if(board.getvalue(i+1, j-1) == 0 or board.getvalue(i+1, j-1) == 'posPo'):
                gw.drawyellowsquare(i+1, j-1)
                board.setvalue(i+1,j-1,'posPo')
                break
            if(board.getvalue(i+1,j-1) == valJoueur):
                break
            j=j-1
            i=i+1
            
def posPoDiagoGaucheHaut(board, gw, i, j, valEntre, valJoueur):
    if(j<=0 or j>=7 or i<=0 or i >=7):
        return 0
    if(board.getvalue(i-1,j-1) == valEntre):
        while(j>0 and i>0):
            if(board.getvalue(i-1, j-1) == 0 or board.getvalue(i-1, j-1) == 'posPo'):
                gw.drawyellowsquare(i-1, j-1)
                board.setvalue(i-1,j-1,'posPo')
                break
            if(board.getvalue(i-1,j-1) == valJoueur):
                break
            j=j-1
            i=i-1

def posPoDroite(board, gw, i, j, valEntre, valJoueur):
    if(j>=7):
        return 0
    if(board.getvalue(i,j+1) == valEntre and j < 7):
        for k in range(7-j):
            if(board.getvalue(i, j+k+1) == valJoueur):
                break
            if(board.getvalue(i, j+k+1) == 0 or board.getvalue(i, j+k+1) == 'posPo'):
                gw.drawyellowsquare(i, j+k+1)
                board.setvalue(i,j+k+1,'posPo')
                break
            
def posPoGauche(board, gw, i, j, valEntre, valJoueur):
    if(j<=0):
        return 0
    if(board.getvalue(i, j-1) == valEntre):
        for k in range(j):
            if(board.getvalue(i, j-k-1) == valJoueur):
                break
            if(board.getvalue(i, j-k-1) == 0 or board.getvalue(i, j-k-1) == 'posPo'):
                gw.drawyellowsquare(i,j-k-1)
                board.setvalue(i,j-k-1,'posPo')
                break
            
def posPoHaut(board, gw, i, j, valEntre, valJoueur):
    if(i<=0):
        return 0
    if(board.getvalue(i-1,j) == valEntre):
        for k in range(i):
            if(board.getvalue(i-k-1, j) == valJoueur):
                break
            if(board.getvalue(i-k-1,j) == 0 or board.getvalue(i-k-1, j) == 'posPo'):
                gw.drawyellowsquare(i-k-1,j)
                board.setvalue(i-k-1,j,'posPo')
                break
            
def posPoBas(board, gw, i, j, valEntre, valJoueur):
    if(i>=7):
        return 0
    if(board.getvalue(i+1,j) == valEntre):
        for k in range(7-i):
            if(board.getvalue(i+k+1, j) == valJoueur):
                break
            if(board.getvalue(i+k+1,j) == 0 or board.getvalue(i+k+1, j) == 'posPo'):
                gw.drawyellowsquare(i+k+1,j)
                board.setvalue(i+k+1,j,'posPo')
                break


"""

    changeDroite va changer tout les pions après la pose d'un nouveau pion
  
"""
            
def changeDroite(board, gw, i, j, valEntre, valJoueur):
    tupGene = []
    if(j>=7):
        return 0
    if(board.getvalue(i,j+1) == valEntre):
        while(j<7):
            j=j+1
            if(board.getvalue(i,j) == valEntre):
                tupGene.append(j)
            elif(board.getvalue(i,j) == valJoueur):
                for k in range(len(tupGene)):
                    if(valJoueur == 'blue'):
                        gw.drawbluedisk(i,tupGene[k])
                        board.setvalue(i,tupGene[k], 'blue')
                    elif(valJoueur == 'red'):
                        gw.drawreddisk(i,tupGene[k])
                        board.setvalue(i,tupGene[k], 'red')
                            
def changeGauche(board, gw, i, j, valEntre, valJoueur):
    tupGene = []
    if(j<=0):
        return 0
    if(board.getvalue(i,j-1) == valEntre):
        while(j>0):
            j=j-1
            if(board.getvalue(i,j) == valEntre):
                tupGene.append(j)
            elif(board.getvalue(i,j) == valJoueur):
                for k in range(len(tupGene)):
                    if(valJoueur == 'blue'):
                        gw.drawbluedisk(i,tupGene[k])
                        board.setvalue(i,tupGene[k], 'blue')
                    elif(valJoueur == 'red'):
                        gw.drawreddisk(i,tupGene[k])
                        board.setvalue(i,tupGene[k], 'red')
                                       
def changeHaut(board, gw, i, j, valEntre, valJoueur):
    tupGene = []
    if(i<=0):
        return 0
    if(board.getvalue(i-1,j) == valEntre):
        while(i>0):
            i=i-1
            if(board.getvalue(i,j) == valEntre):
                tupGene.append(i)
            elif(board.getvalue(i,j) == valJoueur):
                for k in range(len(tupGene)):
                    if(valJoueur == 'blue'):
                        gw.drawbluedisk(tupGene[k],j)
                        board.setvalue(tupGene[k],j, 'blue')
                    elif(valJoueur == 'red'):
                        gw.drawreddisk(tupGene[k],j)
                        board.setvalue(tupGene[k],j, 'red')
            
def changeBas(board, gw, i, j, valEntre, valJoueur):
    tupGene = []
    if(i>=7):
        return 0
    if(board.getvalue(i+1,j) == valEntre):
        while(i<7):
            i=i+1
            if(board.getvalue(i,j) == valEntre):
                tupGene.append(i)
            elif(board.getvalue(i,j) == valJoueur):
                for k in range(len(tupGene)):
                    if(valJoueur == 'blue'):
                        gw.drawbluedisk(tupGene[k],j)
                        board.setvalue(tupGene[k],j, 'blue')
                    elif(valJoueur == 'red'):
                        gw.drawreddisk(tupGene[k],j)
                        board.setvalue(tupGene[k],j, 'red')
                        
def changeDiagoBasD(board, gw, i, j, valEntre, valJoueur):
    tupI = []
    tupJ = []
    if(i>=7 or j>=7):
        return 0
    if(board.getvalue(i+1,j+1) == valEntre):
        while(i<7 and j<7):
            i=i+1
            j=j+1
            if(board.getvalue(i,j) == valEntre):
                tupI.append(i)
                tupJ.append(j)
            elif(board.getvalue(i,j) == valJoueur):
                for k in range(len(tupI)):
                    if(valJoueur == 'blue'):
                        gw.drawbluedisk(tupI[k],tupJ[k])
                        board.setvalue(tupI[k],tupJ[k], 'blue')
                    elif(valJoueur == 'red'):
                        gw.drawreddisk(tupI[k],tupJ[k])
                        board.setvalue(tupI[k],tupJ[k], 'red')
                        
def changeDiagoBasG(board, gw, i, j, valEntre, valJoueur):
    tupI = []
    tupJ = []
    if(i>=7 or j<=0):
        return 0
    if(board.getvalue(i+1,j-1) == valEntre):
        while(i<7 and j>0):
            i=i+1
            j=j-1
            if(board.getvalue(i,j) == valEntre):
                tupI.append(i)
                tupJ.append(j)
            elif(board.getvalue(i,j) == valJoueur):
                for k in range(len(tupI)):
                    if(valJoueur == 'blue'):
                        gw.drawbluedisk(tupI[k],tupJ[k])
                        board.setvalue(tupI[k],tupJ[k], 'blue')
                    elif(valJoueur == 'red'):
                        gw.drawreddisk(tupI[k],tupJ[k])
                        board.setvalue(tupI[k],tupJ[k], 'red')
                        
def changeDiagoHautG(board, gw, i, j, valEntre, valJoueur):
    tupI = []
    tupJ = []
    if(i<=0 or j<=0):
        return 0
    if(board.getvalue(i-1,j-1) == valEntre):
        while(i>0 and j>0):
            i=i-1
            j=j-1
            if(board.getvalue(i,j) == valEntre):
                tupI.append(i)
                tupJ.append(j)
            elif(board.getvalue(i,j) == valJoueur):
                for k in range(len(tupI)):
                    if(valJoueur == 'blue'):
                        gw.drawbluedisk(tupI[k],tupJ[k])
                        board.setvalue(tupI[k],tupJ[k], 'blue')
                    elif(valJoueur == 'red'):
                        gw.drawreddisk(tupI[k],tupJ[k])
                        board.setvalue(tupI[k],tupJ[k], 'red')

def changeDiagoHautD(board, gw, i, j, valEntre, valJoueur):
    tupI = []
    tupJ = []
    if(i<=0 or j>=7):
        return 0
    if(board.getvalue(i-1,j+1) == valEntre):
        while(i>0 and j<7):
            i=i-1
            j=j+1
            if(board.getvalue(i,j) == valEntre):
                tupI.append(i)
                tupJ.append(j)
            elif(board.getvalue(i,j) == valJoueur):
                for k in range(len(tupI)):
                    if(valJoueur == 'blue'):
                        gw.drawbluedisk(tupI[k],tupJ[k])
                        board.setvalue(tupI[k],tupJ[k], 'blue')
                        
                    elif(valJoueur == 'red'):
                        gw.drawreddisk(tupI[k],tupJ[k])
                        board.setvalue(tupI[k],tupJ[k], 'red')

def attribut(nbcols, nbrows, board,gw,joueur,i,j):
    advers = ''
    if joueur == 'blue' :
        advers = 'red'
    elif joueur == 'red':
        advers = 'blue'
    
    changeBas(board, gw, i, j, advers, joueur)
    changeHaut(board, gw, i, j, advers, joueur)
    changeDroite(board, gw, i, j, advers, joueur)
    changeGauche(board, gw, i, j, advers, joueur)
    changeDiagoHautD(board, gw, i, j, advers, joueur)
    changeDiagoHautG(board, gw, i, j, advers, joueur)
    changeDiagoBasD(board, gw, i, j, advers, joueur)
    changeDiagoBasG(board, gw, i, j, advers, joueur)
    
"""
    les fonctions de joueur, iaSimple, iaComplexe
"""

def joueur(couleur,nbcols,nbrows,board,gw,queue):
    cleanTable(nbcols,nbrows,board,gw)
    chercheZoneJouable(nbcols, nbrows, board,gw, couleur)
    count = 0
    for i in range(nbcols):
        for j in range(nbrows):
            if board.getvalue(i,j) == 'posPo' :
                count = count + 1
    if count != 0 :
        coord = waitformouseclick(queue)
        while(board.getvalue(coord[0],coord[1]) != 'posPo'):
            coord = waitformouseclick(queue)
        if(board.getvalue(coord[0],coord[1]) == 'posPo'):
            gw.drawwhitesquare(coord[0],coord[1])
            if(couleur == 'red'):
                gw.drawreddisk(coord[0], coord[1])
                board.setvalue(coord[0], coord[1], "red")
                attribut(nbcols, nbrows, board,gw, "red",coord[0], coord[1])
            if(couleur == 'blue'):
                gw.drawbluedisk(coord[0], coord[1])
                board.setvalue(coord[0], coord[1], "blue")
                attribut(nbcols, nbrows, board,gw, "blue",coord[0], coord[1])
            
def choixCoordJouable(nbcols, nbrows, board):
    coordI = []
    coordJ = []
    count = 0
    choix = []
    for i in range(nbcols):
        for j in range(nbrows):
            if board.getvalue(i,j) == 'posPo' :
                coordI.append(i)
                coordJ.append(j)
                count = count + 1
    if count != 0 :
        taille = len(coordI) 
        x = randint(0,taille-1)
        choix.append(coordI[x])
        choix.append(coordJ[x])
        return choix
    else :
        return ['null']

def iaSimple(couleur,nbcols,nbrows,board,gw,queue):
    cleanTable(nbcols,nbrows,board,gw)
    chercheZoneJouable(nbcols, nbrows, board,gw, couleur)
    coord = choixCoordJouable(nbcols,nbrows,board)
    if coord[0] != 'null' :
        gw.drawwhitesquare(coord[0],coord[1])
        if couleur == "red" and len(coord) != 0:
            gw.drawwhitesquare(coord[0],coord[1])
            gw.drawreddisk(coord[0], coord[1])
            board.setvalue(coord[0], coord[1], "red")
            attribut(nbcols, nbrows, board,gw, "red",coord[0], coord[1])
            cleanTable(nbcols,nbrows,board,gw)
        if couleur == "blue" and len(coord) != 0:
            gw.drawwhitesquare(coord[0],coord[1])
            gw.drawbluedisk(coord[0], coord[1])
            board.setvalue(coord[0], coord[1], "blue")
            attribut(nbcols, nbrows, board,gw, "blue",coord[0], coord[1])
            cleanTable(nbcols,nbrows,board,gw)
            
def iaComplexe(couleur, nbcols, nbrows, board, gw, queue):
    cleanTable(nbcols, nbrows, board, gw)
    chercheZoneJouable(nbcols, nbrows, board,gw, couleur)
    coord = compte(nbcols, nbrows, board, gw, couleur)
    if coord[0] != -1 :
        gw.drawwhitesquare(coord[0],coord[1])
        if couleur == "red" and len(coord) != 0:
            gw.drawwhitesquare(coord[0],coord[1])
            gw.drawreddisk(coord[0], coord[1])
            board.setvalue(coord[0], coord[1], "red")
            attribut(nbcols, nbrows, board,gw, "red",coord[0], coord[1])
            cleanTable(nbcols,nbrows,board,gw)
        if couleur == "blue" and len(coord) != 0:
            gw.drawwhitesquare(coord[0],coord[1])
            gw.drawbluedisk(coord[0], coord[1])
            board.setvalue(coord[0], coord[1], "blue")
            attribut(nbcols, nbrows, board,gw, "blue",coord[0], coord[1])
            cleanTable(nbcols,nbrows,board,gw)

"""
    fonction de end game, compte si il y a encore des tours possibles ou non
"""

def plusDeSolution(nbcols,nbrows,board,gw,queue):
    chercheZoneJouable(nbcols, nbrows, board,gw,"blue")
    chercheZoneJouable(nbcols, nbrows, board,gw,"red")
    count = 0
    for i in range(nbcols):
        for j in range(nbrows):
            if(board.getvalue(i,j) == 'posPo'):
                count = count + 1
    cleanTable(nbcols,nbrows,board,gw)
    if count == 0 :
        print("plus de solutions")
        return 1
    else :
        return 0


def comptePoint(nbcols,nbrows,board, gw ,queue):
    countB = 0
    countR = 0
    for i in range(nbcols):
       for j in range(nbrows):
           if(board.getvalue(i,j) == "blue"):
               countB = countB + 1
           elif(board.getvalue(i,j) == "red"):
               countR = countR +1
    print("joueur bleu : " , countB , " pions")
    print("joueur rouge : " , countR , " pions")
    if plusDeSolution(nbcols,nbrows,board,gw,queue) == 1 :
        if(countB > countR):
            print("joueur 2 à gagné")
        elif(countB < countR):
            print("joueur 1 à gagné")
        else:
            print("égalité")
        

def askstrategy():
    """
    DO NOT CHANGE THIS FUNCTION
    Ask for the IA strategy
    :return: 'b' for a basic strategy, 'a' for an advance strategy
    """
    res = ''
    while res != 'b' and res != 'a':
        res = input('L\'IA doit-elle utiliser une stratégie (b)asique ou (a)vancée ? ')
        if res != 'b' and res != 'a':
            print('Il faut répondre b ou a, merci.')
    return res


def fixparameters():
    """
    DO NOT CHANGE THIS FUNCTION
    fix the parameters
    :return: max pixels, number of rows, number of columns, playerone, playertwo, strategyone, strategytwo
    """
    nbmaxres = 1000
    nbrows = 8
    nbcols = 8
    playerone = askplayer('rouge')
    if playerone == 'I':
        strategyone = askstrategy()
    else:
        strategyone = ''
    playertwo = askplayer('bleu')
    if playertwo == 'I':
        strategytwo = askstrategy()
    else:
        strategytwo = ''

    return nbmaxres, nbrows, nbcols, playerone, playertwo, strategyone, strategytwo


def run():
    """
    DO NOT CHANGE THIS FUNCTION
    Fix the size of the board, set the players, creates the graphical board, create the communication channel
     between the threads and launch the game
    :return: nothing
    """
    nbmaxres, nbrows, nbcols, playerone, playertwo, strategyone, strategytwo = fixparameters()

    queue = Queue()

    gw = GraphicWindow(nbmaxres, nbrows, nbcols, queue)

    gamethread = Thread(target=game, args=(gw, queue, nbrows, nbcols, playerone, playertwo, strategyone, strategytwo))
    gamethread.daemon = True
    gamethread.start()

    gw.draw()


def waitformouseclick(queue):
    """
    DO NOT CHANGE THIS FUNCTION
    Wait for a mouse click on the graphical board and return the coordinate
    :param queue: event queue
    :return: tuple (x, y) wichangeDroite(board, gw, i, j, valEntre, valJoueur)th x the line number and y the column number
    """
    return queue.get()


def game(gw, queue, nbrows, nbcols, playerone, playertwo, strategyone, strategytwo):
    """
    This is the entry function for the game. This the main function where you should start the project
    :param gw: la fenêtre graphique pour afficher
    :param queue: pour la communication entre les threads
    :param nbrows: nombre de lignes
    :param nbcols: nombre de colonnes
    :param playerone: 'h' si le premier joueur est humain, 'I' si c'est l'IA
    :param playertwo: 'h' si le second joueur est humain, 'I' si c'est l'IA
    :param strategyone: 'b' si l'IA une utilise une approche basique, 'a' si elle utilise une approche avancée
    :param strategyone: 'b' si l'IA deux  utilise une approche basique, 'a' si elle utilise une approche avancée
    :return: rien
    """
    k=0
    fin = 0
    print()
    
    board = Array2D(8,8)
    for i in range(nbcols):
        for j in range(nbrows):
            board.setvalue(i,j,0)

    
    # Drawing the blue disks
    gw.drawbluedisk(3, 3)
    board.setvalue(3,3,'blue')
    gw.drawbluedisk(4, 4)
    board.setvalue(4,4,'blue')
    # Drawing the red disks
    gw.drawreddisk(4,3)
    board.setvalue(4,3,'red')
    gw.drawreddisk(3, 4)
    board.setvalue(3,4,'red')
    
    # boucle de jeu, tout se déroule dans cette boucle 
    while(fin != 1) :
        if(playerone == "h"):
            print("Au tour du joueur rouge")
            joueur("red",nbcols,nbrows,board,gw,queue)
        elif(playerone == "I" and strategyone == 'b'):
            iaSimple("red",nbcols,nbrows,board,gw,queue)
        elif(playerone =='I' and strategyone == 'a'):
            iaComplexe("red", nbcols, nbrows, board, gw, queue)
        if(playertwo == "h"):
            print("Au tour du joueur bleu")
            joueur('blue',nbcols,nbrows,board,gw,queue)
        elif(playertwo == "I" and strategytwo == 'b'):
            iaSimple('blue',nbcols,nbrows,board,gw,queue)
        elif(playertwo == 'I' and strategytwo == 'a'):
            iaComplexe("blue", nbcols, nbrows, board, gw, queue)
        
        comptePoint(nbcols,nbrows,board,gw,queue)
        fin = plusDeSolution(nbcols,nbrows,board,gw,queue)
        
# Start the game
# DO NOT CHANGE THIS INSTRUCTION
run()

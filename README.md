# Sobel-Operator

#### Aplicatia consta in aplicarea Operatorului Sobel pe o imagine aleasa de utilizator prin intermediul Command Prompt. Comanda va constata in numele fisierului „.jar” urmat de 2 parametri: calea fisierului de intrare, respectiv calea folderului pentru salvarea noii poze. De altfel,  datorita ierharhiei de derivare din cadrul claselor, s-a lasat loc de implementare pentru mai multe tipuri de filtre de imagine, respectiv mai multi algoritmi. 


#### Operatorul Sobel este folosit in procesarea de imagini, mai exact in algoritmi de detectie a marginilor, creand o imagine alb-negru, in care se evidentiaza marginile. Acesta se bazeaza pe convolutia dintre imagine si un filtru de 3x3, fiind astfel relativ necostisitor in termeni de computatie. Convolutia se aplica intre matricea imagine si matricele Gx si Gy:
 
#### Astfel, algoritmul de aplicare a filtrului consta in parcurgerea matricii imagine ->selectarea blocului 3x3-> aplicarea operatorului->salvarea noii valori in pixelul corespunzator blocului. 

#### Aplicatia are la baza o arhitectura orientata pe obiecte facand astfel posibila, dezvoltarea de noi filtre, respectiv algoritmi pentru procesarea de imagini. 
	Clasele folosite sunt urmatoarele: 
* Clasa Pixel
* 	Clasa Imagine (agregare: matrice pixel)
* 	Clasa Algoritm (interfata)
* 	Clasa FiltruImagine (clasa abstracta derivata din Algoritm)
* 	Clasa OperatorSobel (clasa specifica operatorului Sobel, implementand algoritmul de aplicare al acestuia)

#### Clasa Pixel
Are ca proprietati 3 variabile de tip int : r,g,b, reprezentand valorile pentru cele proprietati ale unui pixel: Rosu, Verde, Albastru. Prin modificarea acestor trei variabile, se poate genera orice culoare ce poate fi aplicata unui pixel.
#### Clasa Imagine
	In clasa Imagine se regaseste agregarea, fiind nevoie de o matrice de tip Pixel, mai devreme definita. O alta proprietate este reprezentata de dimensiunile matricii. Astfel, am folosit 2 variabile de tip int width, height. De altfel, este nevoie de calea fisierului de citire cat si de calea fisierului de afisare a imaginii, astfel, am folosit 2 variabile de tip String inputPath respectiv outputPath. 
#### Ca si metode am implementat : 
*	Constructor fara parametrii;
*	Constructor cu parametrii: public Image(int width, int height, String inputPath, String outputPath);
* Constructor de copiere: public Image(Image img)
*	Metoda pentru citirea unui fisier de tip „.bmp”;
*	Metoda pentru generarea unui fisier de tip „.bmp”;
#### Clasa Algoritm
	Aceasta interfateaza algoritmi de tip procesare de imagine, avand ca si metoda void AplicareAlgoritm();
#### Clasa FiltruImagine
	FiltruImagine este o clasa abstracta ce are ca proprietati doua variabile: imgInitial, imgNoua. Acestea au rolul de a retine imaginea initiala, fiind posibila compararea cu cea finala, dupa aplicarea algoritmului. Constructorul initializeaza imaginea initiala, fiind facuta faza de citire a acesteia din calea data ca si parametru. 
#### Clasa OperatorSobel
	Reprezinta implementarea filtrului sobel, aceasta fiind derivata din clasa FiltruImagine. Are ca si proprietati noi, pe langa cele mostenite, matricile de dimensiuni 3x3 Gx respectiv Gy. Deoarece filtrul se aplica doar imaginilor de tip alb-negru, este necesara implementarea unei metode, care va transforma imaginea initiala in una de tip Gray Scale. Pe langa aceasta, se implementeaza metoda #### AplicareAlgoritm() care va aplica operatorul Sobel, prin regulile operatorului de convolutie.
	Pentru aplicarea filtrului pentru o imagine este necesara generarea unui obiect de tip OperatorSobel, prin intermediul constructorului, care primeste ca parametri args[0], args[1].
OperatorSobel os = new OperatorSobel(args[0], args[1]); 
	De altfel, urmatorul pas este aplicarea filtrului, folosind metoda AplicareAlgoritm();
os.AplicareAlgoritm();


#### Timpi de executie
*	Faza de citire fisier sursa: 184ms;
*	Aplicare filtru: 48ms;
*	Faza de afisare: 137ms;

        

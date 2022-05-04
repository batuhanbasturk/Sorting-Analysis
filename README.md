# Nasil Kullaniliyor
* SortingAlgorithms classindan bir obje uretiyor ve buna sortlayacagimiz arrayi veriyoruz
* Objenin 4 tane degiskeni var: arrayNotSorted, tempArray, time ve count
1. arrayNotSorted = Her seferinde ayni arrayi yollamamak adina ilk yolladigimiz arrayi burada sakliyoruz ve degistirmiyoruz
2. tempArray = Her sorting algoritmasindan sonra, copyArray() fonksiyonu ile arrayNotSorted arrayini bu arrayin icine kopyaliyoruz ve sorting yaparken bu arrayi yolluyoruz (bknz: sa.getTempArray())
3. time = Sorting algoritmasinda gecen sureyi hesaplar
4. count = Henuz hazir degil
* Olusturdugumuz objeyi (bknz: sa), sa.insertionSort(sa.getTempArray()) kullanarak, istedigimiz sort fonksiyonu ile, arrayi sortluyoruz. Daha sonrasinda time count gibi degiskenleri get fonksiyonlari ile alabiliriz.
* Arrayi sortladiktan sonra sa.copyArray() yazarak tempArrayimize sortlanmamis arrayimizi koyuyoruz ve boylelikle ayni arrayi baska fonksiyonlarla sortlanabilmeye hazir hale getiriyoruz

# Yapilacaklar

* ~~SortingAlgorithms classina diger algoritmalar eklenecek.~~
* ~~Surelerin hesaplanmasi yapilacak~~
* ~~Count = O sorting algoritmasindaki en cok tekrar eden kodun kac kez tekrar ettigini sayan bir degisken haline getirilecek, yani her sorting algoritmasinin most common linei bulunacak~~
* ~~SortingAlgorithms classina startTimer ve stopTimer fonksiyonlari eklenecek, kolay kullanim acisindan~~
* ~~TestArea classina random uzunlukta, random degerlere sahip array uretebilen bir fonksiyon yazilacak~~
* ~~TestArea classina verilen inputu, inputun sortlandigi algoritmayi, sortlanma suresini, sortlanirken kac kere islem yaptigini (count) **ayri ayri** txt fileina koyacak kod yazilacak~~
* Olusturulan txt filelari excel ortamina gecirilecek
* Cikan veriler grafiklestirilecek, karsilastirmalari yapilacak
* Rastgele veriler harici, halihazirda sortlanmis arrayler, ters sortlanmis arrayler gibi worst caseleri tetikleyecek arrayler bulunacak ve bunlar da test edilecek
* Rapor yazilacak
* Istiklal marsi ve kapanis
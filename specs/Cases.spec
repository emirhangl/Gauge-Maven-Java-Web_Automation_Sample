Enuygun.com case study
=====================
Created by gule on 8.02.2024

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

* "https://www.enuygun.com" Sayfasına gidilir
     
Case 1
----------------
tags:case1
* "ANASAYFA_GIDIS_DONUS_BUTON" butonuna tıklanır
* gidiş yönü olarak "İstanbul" seçilir
* dönüş yönü olarak "Ankara" seçilir
* gidiş tarihi "14" "Şub" "2024" olarak seçilir
* dönüş tarihi "20" "Şub" "2024" olarak seçilir
* yetişkin yolcu sayısı "3" olarak seçilir
* çocuk yolcu sayısı "0" olarak seçilir
* bebek yolcu sayısı "0" olarak seçilir
* uçak sınıfı "Ekonomi" olarak seçilir
* "YOLCU_SAYISI_TAMAM_BUTON" butonuna tıklanır
* "UCUZ_BILET_BUL_BUTON" butonuna tıklanır
* "LISTEDE_ILK_SEC_BUTON" elementinin görülmesi beklenir
* gidiş kalkış varış saatleri filtresinden kalkış saati "10" ile "18" arası seçilir
* uçuşların kalkış saatlerinin "10:00" ile "18:00" arasında olduğu kontrol edilir

Case 2
----------------
tags:case2
* "ANASAYFA_GIDIS_DONUS_BUTON" butonuna tıklanır
* gidiş yönü olarak "İstanbul" seçilir
* dönüş yönü olarak "Ankara" seçilir
* gidiş tarihi "14" "Şub" "2024" olarak seçilir
* dönüş tarihi "20" "Şub" "2024" olarak seçilir
* yetişkin yolcu sayısı "3" olarak seçilir
* çocuk yolcu sayısı "0" olarak seçilir
* bebek yolcu sayısı "0" olarak seçilir
* uçak sınıfı "Ekonomi" olarak seçilir
* "YOLCU_SAYISI_TAMAM_BUTON" butonuna tıklanır
* "UCUZ_BILET_BUL_BUTON" butonuna tıklanır
* "LISTEDE_ILK_SEC_BUTON" elementinin görülmesi beklenir
* gidiş kalkış varış saatleri filtresinden kalkış saati "10" ile "18" arası seçilir
* listelenen uçuşların fiyatlarının artan şekilde geldiği kontrol edilir

Case 3
--------------------
tags:case3
Impact'i en yüksek olacağını düşündüğüm senaryo, bu platformun en iddialı mottosunun; piyasadaki enuygun bileti bulabileceğinizin temin edilmesi olduğundan, "Ucuz bilet bul" servisinin bir
sebebten çalışmaması, kullanıcıda büyük memnuniyetsizlik uyandırıp platformu terk edip tekrar gelmemesine sebepiyet verecektir. Bununla ilgili çeşitli case'ler düşünülebilir. Ben en temeli
için senaryoyu aşağıdaki gibi hazırlıyorum.
* "ANASAYFA_GIDIS_DONUS_BUTON" butonuna tıklanır
* gidiş yönü olarak "İstanbul" seçilir
* dönüş yönü olarak "Ankara" seçilir
* gidiş tarihi "14" "Şub" "2024" olarak seçilir
* dönüş tarihi "20" "Şub" "2024" olarak seçilir
* yetişkin yolcu sayısı "3" olarak seçilir
* çocuk yolcu sayısı "0" olarak seçilir
* bebek yolcu sayısı "0" olarak seçilir
* uçak sınıfı "Ekonomi" olarak seçilir
* "YOLCU_SAYISI_TAMAM_BUTON" butonuna tıklanır
* "UCUZ_BILET_BUL_BUTON" butonuna tıklanır
* "LISTEDE_ILK_SEC_BUTON" elementinin görülmesi beklenir
package com.example.patrikssmakresa

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RecipeViewModel : ViewModel() {
    private val _recipes = MutableStateFlow(
        listOf(
            RecipeItem(
                title = "Boeuf Bourguignon",
                category = "Kött",
                notes = """
Långkokt högrev i en mustig rödvinssås med sidfläsk, svamp, morötter och lök, serverad med potatispuré toppad med rostad panko, citronzest och persilja.

Ingredienser (4 port):
• 800 g högrev, skuren i bitar
• 150 g sidfläsk, tärnat
• 250 g svamp
• 10–12 st syltlökar
• 2 st gula lökar, hackade
• 2 st morötter, skivade
• 2 st vitlöksklyftor, finhackade
• 1 flaska fylligt rött vin
• 4 dl köttbuljong
• 1 msk tomatpuré
• 1 tsk torkad timjan och 1 lagerblad
• Smör/olja till stekning, salt och peppar
• 1 dl panko
• Finrivet skal från 1 ekologisk citron
• 1 dl finhackad färsk persilja
• Flingsalt

Gör så här:
1. Stek panko gyllene och krispig. Blanda med citronzest, persilja och flingsalt.
2. Stek sidfläsket knaprigt i en gjutjärnsgryta. Ta upp.
3. Stek svamp och syltlök snabbt. Ta upp och spara.
4. Bryn lök, morot och vitlök. Bryn köttet separat och lägg i grytan.
5. Tillsätt tomatpuré, vin, buljong, timjan, lagerblad och sidfläsk.
6. Låt sjuda under lock i 2–3 timmar tills köttet är mört.
7. Lägg i svamp och syltlök de sista 15 minuterna.
8. Smaka av med salt och peppar. Servera med potatispuré och toppa med panko.

""".trimIndent(),
                imageResId = R.drawable.boeuf_bourguignon
            ),
            RecipeItem(
                title = "Chicken Tikka Masala-spett",
                category = "Fågel",
                notes = """
        Marinera kycklingen i yoghurt och kryddor över natten. Servera med krämig tomatsås och nygräddat naan.

        Ingredienser (4 port):
        • 500 g kycklingfilé, skuren i bitar
        • 2 dl yoghurt
        • 2 tsk garam masala (ICA)
        • 1 tsk paprikapulver
        • Träspett (blötlagda)
        • 2 msk smör
        • 1 gul lök, finhackad
        • 3 vitlöksklyftor, finhackade
        • 1 msk färsk ingefära, riven
        • 1 burk (400 g) krossade tomater
        • 2 dl vispgrädde
        • 1 tsk socker
        • 1 msk tomatpuré
        • 1 tsk tikka masala-krydda (ICA)
        • Salt och svartpeppar
        • Nykokt basmatiris
        • Varmt naanbröd
        • Färsk koriander
        • Skivad röd chili
        • Lite grädde eller yoghurt till garnering

        Gör så här:

        1. Marinera kycklingen:
        Blanda yoghurt, garam masala och paprikapulver. Vänd ner kycklingen och låt marinera i minst 30 minuter, gärna över natten.

        2. Tillaga spetten:
        Trä upp kycklingen på blötlagda träspett. Grilla eller stek tills kycklingen fått fin färg och är helt genomstekt.

        3. Gör såsen:
        Smält smöret i en panna. Fräs lök, vitlök och ingefära tills det mjuknar. Tillsätt tomatpuré och tikka masala-krydda. Häll i krossade tomater och låt puttra i 10 minuter.

        4. Gör såsen krämig:
        Rör ner grädde och socker. Låt sjuda i ytterligare 5 minuter. Smaka av med salt och svartpeppar.

        5. Servera:
        Lägg upp ris och kycklingspett. Häll över den krämiga tomatsåsen och toppa med färsk koriander, chili och lite grädde eller yoghurt. Servera med varmt naanbröd!
    """.trimIndent(),
                imageResId = R.drawable.tikamasala
            ),
            RecipeItem(
                title = "Ramen med karamelliserad färs",
                category = "Kött",
                notes = """
        En smakrik ramen med krämig asiatisk buljong, nudlar och karamelliserad köttfärs. Toppad med ägg, shiitakesvamp, bok choy, vårlök, sesamfrön och chiliolja.

        Ingredienser (2 port):

        Ramenbuljong:
        • 1 msk neutral olja
        • 2 vitlöksklyftor, finhackade
        • 1 tumme färsk ingefära, riven
        • 0,5 msk röd currypasta
        • 1 tsk jordnötssmör eller tahini
        • 1 tsk misopasta
        • 1–2 msk sojasås (smaka av)
        • 2 dl kycklingbuljong
        • 1,5 dl sojamjölk eller kokosmjölk
        • Shiitakesvampar, skivade
        • Bok choy, skivad
        • 1–2 paket nudlar

        Karamelliserad färs:
        • 250 g mager köttfärs
        • 1 msk ostronsås
        • 1 msk sojasås
        • 1 msk mörk sojasås
        • 1 msk sweet chili-sås eller honung

        Topping:
        • 1 ägg
        • Vårlök, skivad
        • Rostade sesamfrön
        • Chiliolja

        Gör så här:

        1. Karamelliserad färs:
        Stek köttfärsen tills den är helt brynt. Tillsätt ostronsås, sojasås, mörk sojasås och sweet chili-sås. Rör om och låt steka ytterligare 2–3 minuter tills färsen blir glansig och karamelliserad.

        2. Gör ramenbuljongen:
        Värm oljan i en gryta. Fräs vitlök och ingefära i cirka 1 minut. Tillsätt currypasta, jordnötssmör, misopasta och sojasås. Rör om ordentligt.

        3. Koka buljongen:
        Häll i kycklingbuljong och soja- eller kokosmjölk. Låt sjuda i 6–7 minuter så att smakerna blandas ordentligt.

        4. Förbered tillbehören:
        Koka ägget efter önskad konsistens. Stek shiitakesvampen lätt i en separat panna.

        5. Koka nudlarna:
        Lägg nudlarna i buljongen och koka enligt förpackningens anvisningar. Tillsätt bok choy under de sista 30 sekunderna.

        6. Servera:
        Fördela nudlar och buljong i två skålar. Toppa med den karamelliserade färsen, delat ägg och stekt svamp. Avsluta med vårlök, rostade sesamfrön och chiliolja.

        Njut!
    """.trimIndent(),
                imageResId = R.drawable.ramen
            ),
            RecipeItem(
                title = "Pure Altitude Chardonnay 2025",
                category = "Vin",
                notes = "En krispig, elegant och otroligt härlig chardonnay",
                imageResId = R.drawable.vinpurealtitude
            ),
            RecipeItem(
                title = "Hummerpasta",
                category = "Fisk",
                notes = """
        En silkeslen hummersås reducerad på skaldjursskal, morot, selleri, konjak och grädde. Toppad med smörslungat hummerkött och färsk gräslök. Serveras med rostat vitlöksbröd och ett passande vitt vin.

        Ingredienser (2 portioner):

        • 2 kokta humrar (köttet plockat, skalen sparade)
        • 200 g linguine eller fettuccine
        • 1 liten morot, finhackad
        • 1 stjälk selleri, finhackad
        • 2 schalottenlökar, finhackade
        • 2 vitlöksklyftor, finhackade
        • 2 msk tomatpuré
        • 2–3 msk konjak
        • 2 dl torrt vitt vin
        • 2 dl krossade tomater
        • 1–2 msk koncentrerad hummerfond
        • 2,5 dl vispgrädde
        • Smör till stekning och montering
        • Färsk gräslök
        • Chiliflakes
        • Salt och nymalen svartpeppar

        Tillbehör:
        • Rostat vitlöksbröd
        • Ett glas vitt vin

        Gör så här:

        1. Förbered skaldjursbasen:
        Plocka ut hummerköttet och spara skalen. Fräs hummerskalen tillsammans med morot, selleri, schalottenlök, vitlök och tomatpuré i smör i en stor gryta på medelhög värme i ett par minuter så att smakerna utvecklas.

        2. Tillsätt konjak och vin:
        Häll i konjaken och låt ånga av. Flambera försiktigt om du vill. Tillsätt vitt vin och hummerfond. Låt vätskan reducera till ungefär hälften.

        3. Koka såsen:
        Häll i krossade tomater och vispgrädde. Låt såsen sjuda på låg värme i 10–15 minuter så att den tar smak av skalen och grönsakerna.

        4. Sila såsen:
        Sila såsen genom en finmaskig sil ner i en ren kastrull. Tryck försiktigt på skalen och grönsakerna för att få ut all smak. Smaka av med salt, svartpeppar och chiliflakes.

        5. Koka pastan:
        Koka linguine eller fettuccine al dente i rikligt med saltat vatten enligt förpackningens anvisningar.

        6. Förbered hummerköttet:
        Värm hummerköttet försiktigt i smör på låg värme i 1–2 minuter. Undvik att översteka så att köttet behåller sin fina konsistens.

        7. Montera och servera:
        Blanda den nykokta pastan direkt med den silkeslena hummersåsen. Toppa med det smörslungade hummerköttet och finhackad gräslök. Servera direkt tillsammans med rostat vitlöksbröd och ett glas vitt vin.
    """.trimIndent(),
                imageResId = R.drawable.hummerpasta
            ),
            RecipeItem(
                title = "Öppen lasagne",
                category = "Vego",
                notes = """
        En härlig italiensk lasagne i lager med krämig ricotta, stekt salsiccia, sparris, grönkål och soltorkade tomater. Toppad med pesto, rostade pistagenötter, parmesan och olivolja.

        Ingredienser (4 port):

        • 8 lasagneplattor (Zetas)
        • 250 g ricotta
        • 250 g salsiccia
        • 1 knippe sparris
        • 3–4 blad grönkål
        • 100 g soltorkade tomater
        • 50 g pistagenötter
        • 3–4 msk pesto
        • Olivolja
        • Salt och svartpeppar
        • Lite torkade italienska örter
        • Vitlökspulver
        • Parmesan, till topping

        Gör så här:

        1. Koka lasagneplattorna:
        Koka lasagneplattorna al dente enligt anvisningarna på förpackningen. Låt rinna av och lägg åt sidan.

        2. Stek salsiccian:
        Ta bort skinnet från salsiccian och dela färsen i mindre bitar. Stek gyllene i lite olivolja.

        3. Förbered grönsakerna:
        Skär sparrisen i mindre bitar och fräs den lätt i olivolja. Krydda med salt, svartpeppar och italienska örter.

        4. Rosta grönkålen:
        Riv grönkålen i mindre bitar. Blanda med lite olivolja och vitlökspulver. Rosta i ugnen tills den blir lätt krispig.

        5. Förbered tomater och pistagenötter:
        Hacka de soltorkade tomaterna och grovhacka pistagenötterna.

        6. Bygg lasagnen:
        Lägg en lasagneplatta på varje tallrik. Toppa med ricotta, sparris, grönkål, soltorkade tomater och stekt salsiccia. Lägg på ytterligare en lasagneplatta och upprepa lagren.

        7. Toppa och servera:
        Klicka över pesto och toppa med hackade pist
    """.trimIndent(),
                imageResId = R.drawable.oppenlasagnevegg
            ),
            RecipeItem(
                title = "Pilgrimsmusslor",
                category = "Fisk",
                notes = """
        En lyxig förrätt med stekta pilgrimsmusslor, krämig Sandefjordsås, sparris, fänkål och regnbågsrom.

        Ingredienser (2 portioner):
        • 6–8 pilgrimsmusslor
        • 1 liten fänkål
        • 6–8 sparrisar
        • 1 dl vispgrädde
        • 75 g smör
        • 1 msk crème fraîche
        • 1–2 tsk citronjuice
        • Dill
        • 50–75 g regnbågsrom
        • Olivolja
        • Salt och svartpeppar

        Gör så här:
        1. Skär fänkålen tunt och sparrisen i mindre bitar. Koka sparrisen lätt och lägg fänkålen i kallt vatten. Pressa lite citron över fänkålen.
        2. Koka upp grädden och låt reducera någon minut. Vispa ner crème fraîche och därefter smöret, lite i taget, tills såsen blir blank och krämig.
        3. Smaka av Sandefjordsåsen med citron, salt och svartpeppar.
        4. Torka pilgrimsmusslorna ordentligt. Salta lätt och stek i riktigt het panna med lite olivolja.
        5. Lägg i en klick smör och stek musslorna tills de får en gyllene yta, cirka 1–2 minuter per sida.
        6. Lägg fänkål och sparris i botten av tallriken. Häll över Sandefjordsåsen och toppa med pilgrimsmusslorna.
        7. Avsluta generöst med regnbågsrom, färsk dill och några droppar dillolja.
        8. Servera direkt!
    """.trimIndent(),
                imageResId = R.drawable.pilgrimsmusslor
            ),
            RecipeItem(
                title = "Amarone della Valpolicella",
                category = "Vin",
                notes = "Capitel de Roari Amarone della Valpolicella Classico från Luigi Righetti. Fylligt och smakrikt med mörka körsbär, torkad frukt och kryddiga toner. En riktigt härlig Amarone att njuta av i lugn och ro",
                imageResId = R.drawable.vinamarone
            ),
            RecipeItem(
                title = "Pilgrimsmusslor",
                category = "Fisk",
                notes = """
        En lyxig förrätt med stekta pilgrimsmusslor, krämig Sandefjordsås, sparris, fänkål och regnbågsrom.

        Ingredienser (2 portioner):
        • 6–8 pilgrimsmusslor
        • 1 liten fänkål
        • 6–8 sparrisar
        • 1 dl vispgrädde
        • 75 g smör
        • 1 msk crème fraîche
        • 1–2 tsk citronjuice
        • Dill
        • 50–75 g regnbågsrom
        • Olivolja
        • Salt och svartpeppar

        Gör så här:
        1. Skär fänkålen tunt och sparrisen i mindre bitar. Koka sparrisen lätt och lägg fänkålen i kallt vatten. Pressa lite citron över fänkålen.
        2. Koka upp grädden och låt reducera någon minut. Vispa ner crème fraîche och därefter smöret, lite i taget, tills såsen blir blank och krämig.
        3. Smaka av Sandefjordsåsen med citron, salt och svartpeppar.
        4. Torka pilgrimsmusslorna ordentligt. Salta lätt och stek i riktigt het panna med lite olivolja.
        5. Lägg i en klick smör och stek musslorna tills de får en gyllene yta, cirka 1–2 minuter per sida.
        6. Lägg fänkål och sparris i botten av tallriken. Häll över Sandefjordsåsen och toppa med pilgrimsmusslorna.
        7. Avsluta generöst med regnbågsrom, färsk dill och några droppar dillolja.
        8. Servera direkt!
    """.trimIndent(),
                imageResId = R.drawable.pilgrimsmusslor
            ),
            RecipeItem(
                title = "Kyckling med paprikasås & ris",
                category = "Fågel",
                notes = """
        Saftig kyckling med karamelliserad glaze, fluffigt ris och en riktigt len sås – ibland är det precis så här enkelt och gott man vill ha det.
         Kyckling & glaze
         600 g kycklingbröstfilé
         1 msk neutral olja + 1 klick smör till stekning
         1,5 msk japansk soja
         1,5 msk flytande honung
         1 vitlöksklyfta, finriven
         Salt och nymalen svartpeppar
         Krämig paprikasås
         2,5 dl vispgrädde
         1 dl crème fraîche
         1,5 msk tomatpuré
         1,5 tsk paprikapulver
         1–2 tsk sriracha eller sambal oelek (efter smak)
         1 msk koncentrerad kycklingfond
         1 klick smör till fräsning
         Salt och nymalen svartpeppar
         Till servering
         4 portioner jasmin- eller basmatiris
         2–3 salladslökar, tunt skivade
         Gör så här
         Koka riset enligt anvisningarna på förpackningen.
         Krydda kycklingfiléerna med salt och svartpeppar. Hetta upp olja och smör i en stekpanna på medelhög värme och stek kycklingen tills den fått en djup, gyllene stekyta på båda sidor.
         Rör ihop soja, honung och riven vitlök. Sänk värmen, häll glazen i pannan och ös kycklingen medan den steker klart (till 70 °C innertemperatur) så att den får en blank, karamelliserad yta. Ta upp kycklingen och låt den vila i några minuter.
         Fräs tomatpuré och paprikapulver hastigt i en klick smör i en kastrull. Vispa ner vispgrädde, crème fraîche, kycklingfond och sriracha. Låt såsen sjuda på svag värme i 5–7 minuter tills den tjocknar och blir slät och glansig. Smaka av med salt och peppar.
         Skär kycklingen i tjocka skivor. Lägg upp riset i djupa tallrikar, häll den varma paprikasåsen runtom och placera kycklingen ovanpå riset. Toppa generöst med tunt skivad salladslök och servera direkt.
    """.trimIndent(),
                imageResId = R.drawable.kycklingris
            ),
            RecipeItem(
                title = "Röding med vitvinssås, gurka & regnbågsrom",
                category = "Fisk",
                notes = """
        Röding
        600 g rödingfilé (gärna med skinn)
        1 msk neutral olja + 25 g smör till stekning
        Salt och nymalen svartpeppar
        Vitvinssås
        1 schalottenlök, finhackad
        1,5 dl torrt vitt vin
        1 msk koncentrerad fiskfond
        2 dl vispgrädde
        50 g kallt smör, tärnat
        1–2 tsk färskpressad citronsaft
        0,5 dl finhackad dill
        Salt och nymalen svartpeppar
        Tillbehör & topping
        0,5 gurka, skalad, urkärnad och fint tärnad
        0,5 dl hasselnötter, rostade och grovhackade
        75 g regnbågsrom
        Färsk dill
        Gör så här
        Rosta hasselnötterna i en torr stekpanna tills de får fin färg, gnugga bort skalet och grovhacka dem. Skala gurkan, gröp ur kärnhuset och skär i små, jämna tärningar.
        Fräs schalottenlöken mjuk i en klick smör i en kastrull utan att den tar färg. Häll på vitt vin och fiskfond och låt reducera tills ungefär hälften återstår.
        Tillsätt vispgrädden och låt såsen sjuda i cirka 5 minuter. Sila eventuellt bort löken, vispa ner det kalla smöret lite i taget och mixa gärna såsen hastigt med stavmixer så den blir luftig. Smaka av med citronsaft, salt och svartpeppar och rör ner finhackad dill.
        Krydda rödingen med salt och svartpeppar. Hetta upp olja i en stekpanna och stek fisken med skinnsidan nedåt på medelhög värme i cirka 3–4 minuter tills skinnet är krispigt. Lägg i smöret, ös fisken och vänd den hastigt de sista 30 sekunderna tills innertemperaturen når 48–50 °C.
        Fördela gurka och hasselnötter i djupa tallrikar och skeda över den varma vitvinssåsen. Lägg på rödingen och toppa generöst med regnbågsrom och färsk dill. Servera direkt!
    """.trimIndent(),
                imageResId = R.drawable.roding
            ),
            RecipeItem(
                title = "Karamelliserade morötter och fetaostkräm",
                category = "Vego",
                notes = """
       Karamelliserade morötter på vispad fetaostkräm
       
4 portioner (som förrätt eller tillbehör)
500–600 g morötter
2 msk olivolja
1,5 msk flytande honung
1 tsk torkad timjan
Flingsalt och nymalen svartpeppar
Vispad fetaostkräm
150 g fetaost
1,5 dl turkisk eller grekisk yoghurt (10 %)
1 liten vitlöksklyfta, finriven
1 tsk färskpressad citronsaft
Nymalen svartpeppar
Topping
2–3 msk extra virgin olivolja
1 tsk torkad timjan
Färsk dill

Gör så här
Sätt ugnen på 225 °C (gärna varmluft). Skala morötterna och dela dem på längden i halvor eller kvartar så att bitarna är ungefär lika tjocka.
Lägg morötterna på en plåt med bakplåtspapper. Ringla över olivolja och honung och krydda med torkad timjan, flingsalt och svartpeppar. Vänd runt ordentligt och lägg dem med snittytan nedåt.
Rosta i mitten av ugnen i 20–25 minuter tills morötterna är mjuka rakt igenom och har fått en djup, karamelliserad och lätt rostad yta.
Mixa fetaost, yoghurt, riven vitlök, citronsaft och svartpeppar med stavmixer eller i matberedare tills krämen är slät och luftig.
Bred ut fetaostkrämen i ett generöst lager på ett fat eller en tallrik och lägg de varma morötterna ovanpå.
Ringla ordentligt med olivolja runt kanten av krämen, strö över torkad timjan och toppa med färska dillvippor direkt före servering.
    """.trimIndent(),
                imageResId = R.drawable.morotter



            )
        )
    )
    val recipes: StateFlow<List<RecipeItem>> = _recipes.asStateFlow()

    fun addRecipe(title: String, category: String) {
        val trimmed = title.trim()
        if (trimmed.isEmpty()) return

        _recipes.update { currentList ->
            currentList + RecipeItem(title = trimmed, category = category)
        }
    }

    fun toggleCooked(id: String) {
        _recipes.update { currentList ->
            currentList.map { item ->
                if (item.id == id) {
                    item.copy(isCooked = !item.isCooked)
                } else {
                    item
                }
            }
        }
    }

    fun setRating(id: String, rating: Int) {
        _recipes.update { currentList ->
            currentList.map { recipe ->
                if (recipe.id == id) {
                    recipe.copy(rating = rating.coerceIn(0, 5))
                } else {
                    recipe
                }
            }
        }
    }

    fun editRecipe(
        id: String,
        newTitle: String,
        newCategory: String,
        newNotes: String,
        newRating: Int
    ) {
        _recipes.update { currentList ->
            currentList.map { recipe ->
                if (recipe.id == id) {
                    recipe.copy(
                        title = newTitle,
                        category = newCategory,
                        notes = newNotes,
                        rating = newRating.coerceIn(0, 5)
                    )
                } else {
                    recipe
                }
            }
        }
    }

    fun deleteRecipe(id: String) {
        _recipes.update { currentList ->
            currentList.filterNot { it.id == id }
        }
    }
}




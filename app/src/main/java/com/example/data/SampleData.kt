package com.example.data

object SampleData {

    val initialStudents = listOf(
        // Pending approvals
        Student(
            id = "std_101",
            name = "Caalaa Ahmad Hasan",
            phone = "+251911456789",
            course = "Hifzii Qur'aanaa",
            registrationDate = "Har'a (01/11/2026)",
            isApproved = false,
            gender = "Dhiira",
            hifzSurah = "Juz 30 (Amma)",
            progressPercent = 0.20f
        ),
        Student(
            id = "std_102",
            name = "Faaxumaa Abdallaah Nuur",
            phone = "+251922334455",
            course = "Qaayidaa Nuuraaniyyaa",
            registrationDate = "Har'a (01/11/2026)",
            isApproved = false,
            gender = "Dubara",
            hifzSurah = "Boqonnaa 4",
            progressPercent = 0.15f
        ),
        Student(
            id = "std_103",
            name = "Ibraahim Mahaammad Alii",
            phone = "+251933778899",
            course = "Hadiisa & Fiqa",
            registrationDate = "Kalee (31/10/2026)",
            isApproved = false,
            gender = "Dhiira",
            hifzSurah = "Al-Arba'in (1-10)",
            progressPercent = 0.30f
        ),
        // Already Approved students
        Student(
            id = "std_104",
            name = "Kadir Jamaal Usmaan",
            phone = "+251944556677",
            course = "Hifzii Qur'aanaa",
            registrationDate = "15/10/2026",
            isApproved = true,
            gender = "Dhiira",
            hifzSurah = "Suuratul Baqara (1-150)",
            progressPercent = 0.65f
        ),
        Student(
            id = "std_105",
            name = "Hawwaa Usmaan Adam",
            phone = "+251912987654",
            course = "Qaayidaa Nuuraaniyyaa",
            registrationDate = "18/10/2026",
            isApproved = true,
            gender = "Dubara",
            hifzSurah = "Darsii 8 (Harakat)",
            progressPercent = 0.50f
        ),
        Student(
            id = "std_106",
            name = "Hamzaa Nuur Mahaammad",
            phone = "+251955112233",
            course = "Hifzii Qur'aanaa",
            registrationDate = "05/10/2026",
            isApproved = true,
            gender = "Dhiira",
            hifzSurah = "Juz 29 (Tabaarak)",
            progressPercent = 0.85f
        ),
        Student(
            id = "std_107",
            name = "Zaynab Aliyyii Kadiir",
            phone = "+251966442211",
            course = "Hadiisa & Fiqa",
            registrationDate = "01/10/2026",
            isApproved = true,
            gender = "Dubara",
            hifzSurah = "Al-Arba'in (1-20)",
            progressPercent = 0.70f
        ),
        Student(
            id = "std_108",
            name = "Bilaal Kadiir Umar",
            phone = "+251977889900",
            course = "Qaayidaa Nuuraaniyyaa",
            registrationDate = "12/10/2026",
            isApproved = true,
            gender = "Dhiira",
            hifzSurah = "Darsii 5 (Tanwiin)",
            progressPercent = 0.40f
        ),
        Student(
            id = "std_109",
            name = "Amiinaa Hasan Baqqalaa",
            phone = "+251988332211",
            course = "Hifzii Qur'aanaa",
            registrationDate = "20/09/2026",
            isApproved = true,
            gender = "Dubara",
            hifzSurah = "Suuratu Aali-Imraan",
            progressPercent = 0.90f
        )
    )

    val qaayidaaLessons = listOf(
        QaayidaaLesson(
            id = 1,
            title = "Darsii 1: Qubee Duwwaa (الحروف المفردة)",
            subtitle = "Alif hanga Yaa'itti sagalee fi qubee adda baafachuu",
            arabicSample = "ا ب ت ث ج ح خ د ذ ر ز س ش ص ض ط ظ ع غ ف ق ك ل م ن و هـ ء ي",
            description = "Darsii kanarratti qubeewwan afaan Arabiffaa 28 sagalee isaanii sirriidhaan adda baafachuun baranna.",
            letters = listOf("ا", "ب", "ت", "ث", "ج", "ح", "خ", "د", "ذ", "ر", "ز", "س", "ش", "ص", "ض", "ط", "ظ", "ع", "غ", "ف", "ق", "ك", "ل", "م", "ن", "و", "هـ", "ء", "ي")
        ),
        QaayidaaLesson(
            id = 2,
            title = "Darsii 2: Qubee Walitti Qindaa'e (الحروف المركبة)",
            subtitle = "Qubee lamaa fi sadii walitti dhufan dubbisuu",
            arabicSample = "لا - با - بلب - كاف - نون",
            description = "Qubee yeroo wal-qabatan bifa isaanii jijjiiran beekuu fi wal-faana sagalee baasuu.",
            letters = listOf("لا", "با", "بلب", "تا", "ثا", "جا", "حا", "خا", "دا", "ذا", "را", "زا", "سا", "شا")
        ),
        QaayidaaLesson(
            id = 3,
            title = "Darsii 3: Qubee Muraqqaba (الحروف المقطعة)",
            subtitle = "Qubee eegala suuraalee Qur'aanaa keessatti dhufan",
            arabicSample = "الم - الر - طه - يس - حم - كهيعص - عسق - ق - ن",
            description = "Qubee eegala suuraalee keessatti dhufan kanneen adda fagaannee dhedheereffachuun dubbifnu.",
            letters = listOf("الم", "المر", "الر", "طسم", "طه", "يس", "حم", "كهيعص", "عسق", "ص", "ق", "ن")
        ),
        QaayidaaLesson(
            id = 4,
            title = "Darsii 4: Harakaat (الحركات الثلاث)",
            subtitle = "Fat-haa (َ), Kasraa (ِ), fi Dammaa (ُ)",
            arabicSample = "بَ - بِ - بُ | تَ - تِ - تُ",
            description = "Harakaata sadan sagalee gabaabaadhaan dubbisuu: Fat-haa (A), Kasraa (I), Dammaa (U).",
            letters = listOf("بَ", "بِ", "بُ", "تَ", "تِ", "تُ", "ثَ", "ثِ", "ثُ", "جَ", "جِ", "جُ", "حَ", "حِ", "حُ")
        ),
        QaayidaaLesson(
            id = 5,
            title = "Darsii 5: Tanwiin (التنوين)",
            subtitle = "Fat-hateyn (ً), Kasrateyn (ٍ), Dammateyn (ٌ)",
            arabicSample = "بً - بٍ - بٌ | تً - تٍ - تٌ",
            description = "Tanwiin jechuun nun sukun sagaleedhaan dhufu garuu hin barreeffamne dha (An, In, Un).",
            letters = listOf("بً", "بٍ", "بٌ", "تً", "تٍ", "تٌ", "ثً", "ثٍ", "ثٌ", "جً", "جٍ", "جٌ")
        ),
        QaayidaaLesson(
            id = 6,
            title = "Darsii 6: Hojii Harakaat fi Tanwiin (تدريبات على الحركات والتنوين)",
            subtitle = "Jecha gaggabaabaa dubbisuu shaakaluu",
            arabicSample = "أَبَدًا - أَحَدٌ - أَخَذَ - بَلَدٍ",
            description = "Qubeeleen harakaata adda addaa qaban walitti hidhamanii yeroo jecha uuman dubbisuu.",
            letters = listOf("أَبَدًا", "أَحَدٌ", "أَخَذَ", "بَلَدٍ", "بَرَرَةٍ", "جَمَعَ", "حَسَدَ", "خَلَقَ")
        ),
        QaayidaaLesson(
            id = 7,
            title = "Darsii 7: Madda Gabaabaa (الألف الصغيرة والياء الصغيرة)",
            subtitle = "Alif, Waw fi Yaa xiqqoo",
            arabicSample = "بٰ - تٰ - ثٰ | هٖ - لٖ",
            description = "Qubee xixiqqoo qubee gubbaa ykn jala jiran kan akka harakaa lamaatti dhedheeratan.",
            letters = listOf("بٰ", "تٰ", "ثٰ", "جٰ", "حٰ", "هٖ", "بٖ", "يٖ")
        ),
        QaayidaaLesson(
            id = 8,
            title = "Darsii 8: Qubee Maddaa fi Liin (حروف المد واللين)",
            subtitle = "Alif dura Fat-haa, Yaa dura Kasraa, Waw dura Dammaa",
            arabicSample = "بَا - بُو - بِي | بَوْ - بَيْ",
            description = "Huruuful Maddi sadan fi Huruuful Liin lamaan dubbisa Qur'aanaa keessatti baay'ee barbaachisoodha.",
            letters = listOf("بَا", "بُو", "بِي", "تَا", "تُو", "تِي", "بَوْ", "بَيْ", "تَوْ", "تَيْ")
        ),
        QaayidaaLesson(
            id = 9,
            title = "Darsii 9: Shaakala Maddaa fi Liin (تدريبات على المد واللين)",
            subtitle = "Jecha madda qabu sirriitti dhedheereffachuu",
            arabicSample = "نُوحِيهَا - أُوتِينَا - قَالُوا",
            description = "Jecha keessatti bakka maddaa adda baasuu fi hanga qiyaasa sirriitti dhedheereffachuu.",
            letters = listOf("نُوحِيهَا", "أُوتِينَا", "قَالُوا", "فِيهَا", "خَوْفٌ", "صَيْفٌ")
        ),
        QaayidaaLesson(
            id = 10,
            title = "Darsii 10: Sukuun (السكون - الجزم)",
            subtitle = "Qubee boqonnaa qabu dubbisuu",
            arabicSample = "أَبْ - أَتْ - أَثْ - أَجْ",
            description = "Qubee sukun qabu kophaa isaatiin hin dubbifamu; qubee dura isaatiin wal-qabata.",
            letters = listOf("أَبْ", "أَتْ", "أَثْ", "أَجْ", "أَحْ", "أَخْ", "أَدْ", "أَذْ", "أَرْ", "أَزْ")
        ),
        QaayidaaLesson(
            id = 11,
            title = "Darsii 11: Shaakala Sukuun (تدريبات على السكون)",
            subtitle = "Jecha sukun qabu hiixuu fi qabachuu",
            arabicSample = "يَعْلَمُ - تَعْلَمُونَ - يَقْرَأُ",
            description = "Jecha sukun qabu shaakaluun qalqalaa fi sagalee qubee eeguu.",
            letters = listOf("يَعْلَمُ", "تَعْلَمُونَ", "يَقْرَأُ", "أَنْعَمْتَ", "مَغْضُوبِ")
        ),
        QaayidaaLesson(
            id = 12,
            title = "Darsii 12: Tashdiid (الشدّة)",
            subtitle = "Qubee dachaa (Shaddah)",
            arabicSample = "أَبَّ - أَبِّ - أَبُّ",
            description = "Tashdiid jechuun qubee tokko si'a lama dubbisuu dha: inni duraa sukun, lammataa harakaa qaba.",
            letters = listOf("أَبَّ", "أَبِّ", "أَبُّ", "أَتَّ", "أَتِّ", "أَتُّ", "أَثَّ", "أَثِّ", "أَثُّ")
        ),
        QaayidaaLesson(
            id = 13,
            title = "Darsii 13: Shaakala Tashdiid (تدريبات على الشدّة)",
            subtitle = "Jecha shaddah qaban dubbisuu",
            arabicSample = "تَبَّتْ - وَتَبَّ - مَرَّ - حَبَّ",
            description = "Tashdiida jecha keessatti shaakaluu fi jabeessanii sagaleessuu.",
            letters = listOf("تَبَّتْ", "وَتَبَّ", "مَرَّ", "حَبَّ", "عَمَّ", "كَلَّا")
        ),
        QaayidaaLesson(
            id = 14,
            title = "Darsii 14: Tashdiid fi Sukuun Wal-faana (الشدّة مع السكون)",
            subtitle = "Qubee shaddaa fi sukun walitti dhufan",
            arabicSample = "مُدْهَامَّتَانِ - وَلَا الضَّالِّينَ",
            description = "Sadarkaa olaanaa kan maddii fi tashdiid wal-faana bakka tokkotti dhufan dubbisuu.",
            letters = listOf("مُدْهَامَّتَانِ", "وَلَا الضَّالِّينَ", "الصَّاخَّةُ", "الطَّامَّةُ")
        ),
        QaayidaaLesson(
            id = 15,
            title = "Darsii 15: Tashdiid Tashdiidaan Dhufe (الشدّة مع الشدّة)",
            subtitle = "Qubee shaddaan shaddaa biraatti aanu",
            arabicSample = "يَزَّكَّىٰ - يَذَّكَّرُ - يَصَّدَّقُ",
            description = "Shaddaan lama wal-bira yeroo dhufan qulqullinaan adda baasanii dubbisuu.",
            letters = listOf("يَزَّكَّىٰ", "يَذَّكَّرُ", "يَصَّدَّقُ", "عِلِّيِّينَ")
        ),
        QaayidaaLesson(
            id = 16,
            title = "Darsii 16: Tashdiid Huruuful Madda Booda (الشدّة بعد حرف المد)",
            subtitle = "Madda Laazim (dhedheerinna harakaat 6)",
            arabicSample = "دَابَّةٍ - حَاجَّ - جَآنٌّ",
            description = "Maddi Laazim jechuun madda booda shaddaan yoo dhufe harakaat 6 dhedheereffama.",
            letters = listOf("دَابَّةٍ", "حَاجَّ", "جَآنٌّ", "تَأْمُرُوٓنِّي")
        ),
        QaayidaaLesson(
            id = 17,
            title = "Darsii 17: Xumura Qaayidaa Nuuraaniyyaa (خاتمة القاعدة النورانية)",
            subtitle = "Aayatoota Qur'aanaa guutuu dubbisuu jalqabuu",
            arabicSample = "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ",
            description = "Barataan darsiilee 16 xumure amma gara Qur'aana qara'uutti qophaa'eera. Al-Faatihaa fi juz 30 eegaluu.",
            letters = listOf("الْحَمْدُ", "لِلَّهِ", "رَبِّ", "الْعَالَمِينَ", "الرَّحْمَٰنِ", "الرَّحِيمِ", "مَالِكِ", "يَوْمِ", "الدِّينِ")
        )
    )

    val shuruuxaItems = listOf(
        ShuruuxItem(
            number = 1,
            titleOromoo = "Islaamummaa",
            titleArabic = "الإسلام",
            description = "Salaanni nama kafaraa ykn mushrika irraa hin fudhatamu. Namni salaatu dura Muslima ta'uu qaba.",
            evidence = "“Hojiin isaanii kan badedha...” (Suuratul Maa'idah)"
        ),
        ShuruuxItem(
            number = 2,
            titleOromoo = "Qalbii Qabaachuu (Aqlii)",
            titleArabic = "العقل",
            description = "Nama maraatuu, machaa'e, ykn qalbiin isaa hin jirre irratti salaanni dirqama miti; qalama irraa kaafameera.",
            evidence = "Hadiisa: “Qalamni nama sadiirraa kaafameera: maraataa hanga fayyutti...”"
        ),
        ShuruuxItem(
            number = 3,
            titleOromoo = "Umurii Gahuu (Tamyiiz)",
            titleArabic = "التمييز",
            description = "Daa'ima addaan baasee beeku (waggaa 7 irraa kaasee) salaata ajajuun, waggaa 10 irratti jabeessuun barbaachisaadha.",
            evidence = "Hadiisa: “Ijoollee keessan yoo waggaa 7 guutan salaatatti ajajaa...”"
        ),
        ShuruuxItem(
            number = 4,
            titleOromoo = "Xahaaraa (Qulqullina Hadathaa)",
            titleArabic = "رفع الحدث",
            description = "Wudhuu'a (wudoo) godhachuu ykn janabaa irraa dhiqachuu. Wudoo malee salaanni hin jiru.",
            evidence = "Hadiisa: “Salaata tokkoo keessanii Rabbiin hin fudhatu yoo hadasa bahe hanga wuduu'a godhatutti.”"
        ),
        ShuruuxItem(
            number = 5,
            titleOromoo = "Awraah Haguuguu (Safaruu)",
            titleArabic = "ستر العورة",
            description = "Dhiiraaf handhuura hanga jilbaatti; dubaraaf qaama guutuu (fuulaa fi harka lamaan malee) uffata sirriitiin haguuguu.",
            evidence = "Qur'aana: “Yaa ilmaan Aadam! Bakka salaata hundatti faaya keessan qabadhaa.”"
        ),
        ShuruuxItem(
            number = 6,
            titleOromoo = "Yeroon Salaataa Seenuu",
            titleArabic = "دخول الوقت",
            description = "Salaanni kamiyyuu yeroo isaa qaba. Yeroon osoo hin seenin ykn yeroo bahe booda sababa malee salaatuun dhowwaadha.",
            evidence = "Qur'aana: “Dhugumatti salaanni mu'uminoota irratti yeroo murtaa'etti dirqama taate.”"
        ),
        ShuruuxItem(
            number = 7,
            titleOromoo = "Qiblaatti Garagaluu",
            titleArabic = "استقبال القبلة",
            description = "Gara Ka'abaa (Masjiidul Haraam) Makkaatti garagaluun dirqama salaataati.",
            evidence = "Qur'aana: “Fuula kee gara Masjiida Kabajamaatti (Ka'abaatti) naannessi.”"
        ),
        ShuruuxItem(
            number = 8,
            titleOromoo = "Niyyaa Qalbii Keessatti Qabaachuu",
            titleArabic = "النية",
            description = "Salaata kam akka salaatu (fkn Zuhri, Asri, Subhii) qalbii isaatti yaaduu. Arrabaan sagaleessuun sunnaa miti.",
            evidence = "Hadiisa: “Hojiin hundi kan murtaa'u qalbii fi niyyaadhaan qofa.”"
        ),
        ShuruuxItem(
            number = 9,
            titleOromoo = "Najasaa Irraa Qulqullaa'uu",
            titleArabic = "إزالة النجاسة",
            description = "Qaama, uffataa fi iddoo irratti salaatan najasaa (balfa) kamirraayyuu guutummaatti qulqulleessuu.",
            evidence = "Qur'aana: “Uffata kees qulqulleessi.” (Suuratul Muddassir)"
        )
    )

    val hadithList = listOf(
        HadithItem(
            id = 1,
            title = "Hadiisa 1: Niyyaa (النيّة)",
            arabicText = "«إِنَّمَا الأَعْمَالُ بِالنِّيَّاتِ، وَإِنَّمَا لِكُلِّ امْرِئٍ مَا نَوَى، فَمَنْ كَانَتْ هِجْرَتُهُ إِلَى اللَّهِ وَرَسُولِهِ، فَهِجْرَتُهُ إِلَى اللَّهِ وَرَسُولِهِ...»",
            oromooTranslation = "“Dhugumatti dalagaaleen hundi kan murtaa'an niyyaadhaan. Namni hundis waanuma niyyate argata. Namni godaansi isaa gara Rabbiitii fi Rasuulaa ta'e, godaansi isaa gara Rabbiitii fi Rasuulaatti barraawaaf...”",
            narrator = "Umar Ibn Al-Khaxxaab (R.A) | Bukhaarii fi Muslim",
            keyLesson = "Hojiin hundi fudhatama kan argatu niyyaa qulqulluu Rabbi qofaaf ta'eeni."
        ),
        HadithItem(
            id = 2,
            title = "Hadiisa 2: Hadiisa Jibriil (حديث جبريل عليه السلام)",
            arabicText = "«قَالَ: يَا مُحَمَّدُ، أَخْبِرْنِي عَنِ الإِسْلاَمِ؟ فَقَالَ: الإِسْلاَمُ أَنْ تَشْهَدَ أَنْ لاَ إِلَهَ إِلاَّ اللَّهُ وَأَنَّ مُحَمَّدًا رَسُولُ اللَّهِ، وَتُقِيمَ الصَّلاَةَ، وَتُؤْتِيَ الزَّكَاةَ...»",
            oromooTranslation = "“Jibriil (A.S) ergaa fidee dhufe: Yaa Muhammad! Islaamummaa irraa naaf himi jedhe. Ergamaan Rabbii (S.A.W) ni jedhan: Islaamummaan Rabbi malee dhugaan gabbartamuu akka hin jirre fi Muhammad ergamaa Rabbii ta'uu ragaa ba'uu, salaata dhaabuu, zakaa kennuu...”",
            narrator = "Umar Ibn Al-Khaxxaab (R.A) | Muslim",
            keyLesson = "Sadarkaa diin Islaamaa sadan: Islaamummaa, Iimaanaa fi Ihsaana beekuu."
        ),
        HadithItem(
            id = 3,
            title = "Hadiisa 3: Utubaalee Islaamaa Shanan (أركان الإسلام)",
            arabicText = "«بُنِيَ الإِسْلاَمُ عَلَى خَمْسٍ: شَهَادَةِ أَنْ لاَ إِلَهَ إِلاَّ اللَّهُ وَأَنَّ مُحَمَّدًا رَسُولُ اللَّهِ، وَإِقَامِ الصَّلاَةِ، وَإِيتَاءِ الزَّكَاةِ، وَحَجِّ البَيْتِ، وَصَوْمِ رَمَضَانَ»",
            oromooTranslation = "“Islaamummaan waan shan irratti ijaaramte: Shahaadaa lamaan qabaachuu, Salaata dhaabuu, Zakaa baasuu, Hajjii godhuu fi Soomana Ramadaanaa soomuu.”",
            narrator = "Abdallaah Ibn Umar (R.A) | Bukhaarii fi Muslim",
            keyLesson = "Islaamummaan akka gamoo manaatti utubaa shanan kanaan dhaabbata."
        ),
        HadithItem(
            id = 4,
            title = "Hadiisa 4: Bid'aa Irraa Fagaachuu (النهي عن الابتداع)",
            arabicText = "«مَنْ أَحْدَثَ فِي أَمْرِنَا هَذَا مَا لَيْسَ فِيهِ فَهُوَ رَدٌّ»",
            oromooTranslation = "“Namni diinii keenya keessatti waan isarraa hin taane haaraa uume, sun deebifamaadha (hin fudhatamu).”",
            narrator = "Aa'ishaa (R.A) | Bukhaarii fi Muslim",
            keyLesson = "Ibaadaa keessatti sunnaa Rasuulaa (S.A.W) hordofuu malee kalaquun dhowwaadha."
        ),
        HadithItem(
            id = 5,
            title = "Hadiisa 5: Diiniin Gorsa (الدين النصيحة)",
            arabicText = "«الدِّينُ النَّصِيحَةُ، قُلْنَا: لِمَنْ؟ قَالَ: لِلَّهِ، وَلِكِتَابِهِ، وَلِرَسُولِهِ، وَلأَئِمَّةِ المُسْلِمِينَ وَعَامَّتِهِمْ»",
            oromooTranslation = "“Ergamaan Rabbii (S.A.W) ni jedhan: Diiniin gorsa (qulqullummaa fi naseehaa dha). Eenyuuf? jennaan: Rabbiif, Kitaaba isaatiif, Ergamaa isaatiif, hogganoota Muslimootaatiif fi Muslimoota hundaaf jedhan.”",
            narrator = "Tamiim Ad-Daarii (R.A) | Muslim",
            keyLesson = "Wal gorsuu, haqa irratti wal dhaamuu fi jaalalaan waliif yaaduu."
        ),
        HadithItem(
            id = 6,
            title = "Hadiisa 6: Obboleessa Ofiitiif Jaallachuu",
            arabicText = "«لاَ يُؤْمِنُ أَحَدُكُمْ حَتَّى يُحِبَّ لِأَخِيهِ مَا يُحِبُّ لِنَفْسِهِ»",
            oromooTranslation = "“Tokkoon keessan iimaanni isaa hin guutamu hanga waan lubbuu ofiitiif jaallatu obboleessa isaatiifis jaallatutti.”",
            narrator = "Anas Ibn Maalik (R.A) | Bukhaarii fi Muslim",
            keyLesson = "Hinaaffaa irraa fagaachuu fi obboleessa Muslimaatiif tola yaaduu."
        ),
        HadithItem(
            id = 7,
            title = "Hadiisa 7: Hasaawa Gaarii Ykn Callisuu",
            arabicText = "«مَنْ كَانَ يُؤْمِنُ بِاللَّهِ وَاليَوْمِ الآخِرِ فَلْيَقُلْ خَيْرًا أَوْ لِيَصْمُتْ...»",
            oromooTranslation = "“Namni Rabbii fi Guyyaa Qiyaamaatti amane, dubbii gaarii haa dubbatu yookiin haa callisu...”",
            narrator = "Abuu Hureeyraa (R.A) | Bukhaarii fi Muslim",
            keyLesson = "Arraba ofii eeggachuu fi dubbii badii irraa callisuu filachuu."
        ),
        HadithItem(
            id = 8,
            title = "Hadiisa 8: Dhiifama fi Aarii To'achuu",
            arabicText = "«أَنَّ رَجُلاً قَالَ لِلنَّبِيِّ صَلَّى اللَّهُ عَلَيْهِ وَسَلَّمَ: أَوْصِنِي، قَالَ: لاَ تَغْضَبْ، فَرَدَّدَ مِرَارًا، قَالَ: لاَ تَغْضَبْ»",
            oromooTranslation = "“Namichi tokko: Na gorsi yaa ergamaa Rabbii jedhe. Hin dallanin jedhaniin. Si'a hedduu irra deddeebi'ee gaafannaan: Hin dallanin jedhaniin.”",
            narrator = "Abuu Hureeyraa (R.A) | Bukhaarii",
            keyLesson = "Aariin madda balleessaati; sabrii fi qabbana qabaachuu."
        ),
        HadithItem(
            id = 9,
            title = "Hadiisa 9: Dhiigaa fi Qabeenya Eeguu",
            arabicText = "«كُلُّ المُسْلِمِ عَلَى المُسْلِمِ حَرَامٌ: دَمُهُ، وَمَالُهُ، وَعِرْضُهُ»",
            oromooTranslation = "“Muslimni hundi Muslima biraa irratti haraama: Dhiigni isaa, qabeenyi isaa fi kabajni (maqaan) isaa.”",
            narrator = "Abuu Hureeyraa (R.A) | Muslim",
            keyLesson = "Muslimoota miidhuu irraa of qusachuu fi nagaa walii eeguu."
        ),
        HadithItem(
            id = 10,
            title = "Hadiisa 10: Tola Ooluu fi Ihsaana",
            arabicText = "«إِنَّ اللَّهَ كَتَبَ الإِحْسَانَ عَلَى كُلِّ شَيْءٍ...»",
            oromooTranslation = "“Dhugumatti Rabbiin waan hunda irratti tola ooluu fi hojii bareechuu (Ihsaana) katabeera...”",
            narrator = "Shaddaad Ibn Aws (R.A) | Muslim",
            keyLesson = "Hojii kamuu qulqullinaa fi naamusa ol-aanaadhaan dalaguu."
        )
    )

    val donationAccounts = listOf(
        DonationAccount(
            bankName = "Baankii Daldala Itoophiyaa (CBE)",
            accountNumber = "1000452398712",
            accountHolder = "Ustaaz Fu'aad Ahmad (Subulu-Salaam)",
            branch = "Finfinnee / Markaza Subulu-Salaam",
            isTelebirr = false
        ),
        DonationAccount(
            bankName = "Telebirr (Kaffaltii Salphaa)",
            accountNumber = "0911567823",
            accountHolder = "Ustaaz Fu'aad Ahmad",
            branch = "Ethio Telecom Mobile Money",
            isTelebirr = true
        ),
        DonationAccount(
            bankName = "Baankii Awaash (Awash Bank)",
            accountNumber = "01320498765400",
            accountHolder = "Markaza Subulu-Salaam",
            branch = "Finfinnee Branch",
            isTelebirr = false
        ),
        DonationAccount(
            bankName = "Baankii Hijraa (Hijra Bank)",
            accountNumber = "1002345678",
            accountHolder = "Markaza Subulu-Salaam Islamic Center",
            branch = "Finfinnee",
            isTelebirr = false
        )
    )

    val initialChatMessages = listOf(
        ChatMessage(
            id = "msg_1",
            senderName = "Caalaa Ahmad",
            message = "Assalamu alaykum Ustaaz Fu'aad! Gaaffii darsii Qaayidaa irratti qaba ture.",
            timestamp = "09:15 AM",
            isFromAdmin = false,
            isMe = false
        ),
        ChatMessage(
            id = "msg_2",
            senderName = "Ustaaz Fu'aad Ahmad",
            message = "Wa alaykumu ssalaam warahmatullaahi wabarakaatuhu! Eeyyee obboleessa koo, gaaffii kee dhiyeessuu dandeessa.",
            timestamp = "09:18 AM",
            isFromAdmin = true,
            isMe = true
        ),
        ChatMessage(
            id = "msg_3",
            senderName = "Faaxumaa Abdallaah",
            message = "Ustaaz, qiraatiin har'aa sa'aatii meeqatti jalqaba?",
            timestamp = "10:02 AM",
            isFromAdmin = false,
            isMe = false
        ),
        ChatMessage(
            id = "msg_4",
            senderName = "Ustaaz Fu'aad Ahmad",
            message = "Darsiin Asrii booda sa'aatii 10:30 (4:30 PM) irratti eegala in shaa Allaah. Hundi keessan wudhuu'aan qophaa'aa.",
            timestamp = "10:05 AM",
            isFromAdmin = true,
            isMe = true
        )
    )
}

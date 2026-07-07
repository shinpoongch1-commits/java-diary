package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 야고보서 5개 장, 각 절의 한글(개역개정)/영어(NIV1984) 본문 데이터 */
public final class BibleData {

    public static final List<List<Verse>> JAMES = buildData();

    private static List<List<Verse>> buildData() {
        List<List<Verse>> chapters = new ArrayList<>();
        List<Verse> ch;

        // 1장 (27절)
        ch = new ArrayList<>();
        ch.add(new Verse("하나님과 주 예수 그리스도의 종 야고보는 흩어져 있는 열두 지파에게 문안하노라", "James, a servant of God and of the Lord Jesus Christ, To the twelve tribes scattered among the nations: Greetings."));
        ch.add(new Verse("내 형제들아 너희가 여러 가지 시험을 만나거든 온전히 기쁘게 여기라", "Consider it pure joy, my brothers, whenever you face trials of many kinds,"));
        ch.add(new Verse("이는 너희 믿음의 시련이 인내를 만들어 내는 줄 너희가 앎이라", "because you know that the testing of your faith develops perseverance."));
        ch.add(new Verse("인내를 온전히 이루라 이는 너희로 온전하고 구비하여 조금도 부족함이 없게 하려 함이라", "Perseverance must finish its work so that you may be mature and complete, not lacking anything."));
        ch.add(new Verse("너희 중에 누구든지 지혜가 부족하거든 모든 사람에게 후히 주시고 꾸짖지 아니하시는 하나님께 구하라 그리하면 주시리라", "If any of you lacks wisdom, he should ask God, who gives generously to all without finding fault, and it will be given to him."));
        ch.add(new Verse("오직 믿음으로 구하고 조금도 의심하지 말라 의심하는 자는 마치 바람에 밀려 요동하는 바다 물결 같으니", "But when he asks, he must believe and not doubt, because he who doubts is like a wave of the sea, blown and tossed by the wind."));
        ch.add(new Verse("이런 사람은 무엇이든지 주께 얻기를 생각하지 말라", "That man should not think he will receive anything from the Lord;"));
        ch.add(new Verse("두 마음을 품어 모든 일에 정함이 없는 자로다", "he is a double-minded man, unstable in all he does."));
        ch.add(new Verse("낮은 형제는 자기의 높음을 자랑하고", "The brother in humble circumstances ought to take pride in his high position."));
        ch.add(new Verse("부한 자는 자기의 낮아짐을 자랑할지니 이는 그가 풀의 꽃과 같이 지나감이라", "But the one who is rich should take pride in his low position, because he will pass away like a wild flower."));
        ch.add(new Verse("해가 돋고 뜨거운 바람이 불어 풀을 말리면 꽃이 떨어져 그 아름다운 모양이 없어지나니 부한 자도 그 행하는 일에 이와 같이 쇠잔하리라", "For the sun rises with scorching heat and withers the plant; its blossom falls and its beauty is destroyed. In the same way, the rich man will fade away even while he goes about his business."));
        ch.add(new Verse("시험을 참는 자는 복이 있도다 이것에 옳다 인정하심을 받은 후에 주께서 자기를 사랑하는 자들에게 약속하신 생명의 면류관을 얻을 것임이니라", "Blessed is the man who perseveres under trial, because when he has stood the test, he will receive the crown of life that God has promised to those who love him."));
        ch.add(new Verse("사람이 시험을 받을 때에 내가 하나님께 시험을 받는다 하지 말찌니 하나님은 악에게 시험을 받지도 아니하시고 친히 아무도 시험하지 아니하시느니라", "When tempted, no one should say, 'God is tempting me.' For God cannot be tempted by evil, nor does he tempt anyone;"));
        ch.add(new Verse("오직 각 사람이 시험을 받는 것은 자기 욕심에 끌려 미혹됨이니", "but each one is tempted when, by his own evil desire, he is dragged away and enticed."));
        ch.add(new Verse("욕심이 잉태한즉 죄를 낳고 죄가 장성한즉 사망을 낳느니라", "Then, after desire has conceived, it gives birth to sin; and sin, when it is full-grown, gives birth to death."));
        ch.add(new Verse("내 사랑하는 형제들아 속지 말라", "Don't be deceived, my dear brothers."));
        ch.add(new Verse("각양 좋은 은사와 온전한 선물이 다 위로부터 빛들의 아버지께로부터 내려오나니 그는 변함도 없으시고 회전하는 그림자도 없으시니라", "Every good and perfect gift is from above, coming down from the Father of the heavenly lights, who does not change like shifting shadows."));
        ch.add(new Verse("그가 그 조물주 중에 우리로 한 첫 열매가 되게 하시려고 자기의 뜻을 좇아 진리의 말씀으로 우리를 낳으셨느니라", "He chose to give us birth through the word of truth, that we might be a kind of firstfruits of all he created."));
        ch.add(new Verse("내 사랑하는 형제들아 너희가 알거니와 사람마다 듣기는 속히 하고 말하기는 더디 하며 성내기도 더디 하라", "My dear brothers, take note of this: Everyone should be quick to listen, slow to speak and slow to become angry,"));
        ch.add(new Verse("사람이 성내는 것이 하나님의 의를 이루지 못함이라", "for man's anger does not bring about the righteous life that God desires."));
        ch.add(new Verse("그러므로 모든 더러운 것과 넘치는 악을 내버리고 너희 영혼을 능히 구원할 바 마음에 심긴 도룰 온유함으로 받으라", "Therefore, get rid of all moral filth and the evil that is so prevalent and humbly accept the word planted in you, which can save you."));
        ch.add(new Verse("너희는 도를 행하는 자가 되고 듣기만 하여 자신을 속이는 자가 되지 말라", "Do not merely listen to the word, and so deceive yourselves. Do what it says."));
        ch.add(new Verse("누구든지 말씀을 듣고 행하지 아니하면 그는 거울로 자기의 생긴 얼굴을 보는 사람과 같으니", "Anyone who listens to the word but does not do what it says is like a man who looks at his face in a mirror"));
        ch.add(new Verse("제 자신을 보고 가서 그 모습이 어떠했는지를 곧 잊어버리거니와", "and, after looking at himself, goes away and immediately forgets what he looks like."));
        ch.add(new Verse("자유롭게 하는 온전한 율법을 들여다보고 있는 자는 듣고 잊어버리는 자가 아니요 실행하는 자니 이 사람은 그 행하는 일에 복을 받으리라", "But the man who looks intently into the perfect law that gives freedom, and continues to do this, not forgetting what he has heard, but doing it — he will be blessed in what he does."));
        ch.add(new Verse("누구든지 스스로 경건하다 생각하며 자기 혀를 재갈 물리지 아니하고 자기 마음을 속이면 이 사람의 경건은 헛것이라", "If anyone considers himself religious and yet does not keep a tight rein on his tongue, he deceives himself and his religion is worthless."));
        ch.add(new Verse("하나님 아버지 앞에서 정결하고 더러움이 없는 경건은 곧 고아와 과부를 그 환난중에 돌보고 또 자기를 지켜 세속에 물들지 아니하는 그것이니라", "Religion that God our Father accepts as pure and faultless is this: to look after orphans and widows in their distress and to keep oneself from being polluted by the world."));
        chapters.add(ch);

        // 2장 (26절)
        ch = new ArrayList<>();
        ch.add(new Verse("내 형제들아 영광의 주 곧 우리 주 예수 그리스도에 대한 믿음을 너희가 가졌으니 사람을 차별하여 대하지 말라", "My brothers, as believers in our glorious Lord Jesus Christ, don't show favoritism."));
        ch.add(new Verse("만일 너희 회당에 금 가락지를 끼고 아름다운 옷을 입은 사람이 들어오고 또 남루한 옷을 입은 가난한 사람이 들어올 때에", "Suppose a man comes into your meeting wearing a gold ring and fine clothes, and a poor man in shabby clothes also comes in."));
        ch.add(new Verse("너희가 아름다운 옷을 입은 자를 눈여겨보고 말하되 여기 좋은 자리에 앉으소서 하고 또 가난한 자에게 말하되 너는 거기 서 있든지 내 발등상 아래에 앉으라 하면", "If you show special attention to the man wearing fine clothes and say, 'Here's a good seat for you,' but say to the poor man, 'You stand there' or 'Sit on the floor by my feet,'"));
        ch.add(new Verse("너희끼리 서로 차별하며 악한 생각으로 판단하는 자가 되는 것이 아니냐", "have you not discriminated among yourselves and become judges with evil thoughts?"));
        ch.add(new Verse("내 사랑하는 형제들아 들을지어다 하나님이 세상에 대하여 가난한 자를 택하사 믿음에 부요하게 하시고 또 자기를 사랑하는 자들에게 약속하신 나라를 상속으로 받게 하지 아니하셨느냐", "Listen, my dear brothers: Has not God chosen those who are poor in the eyes of the world to be rich in faith and to inherit the kingdom he promised those who love him?"));
        ch.add(new Verse("너희는 도리어 가난한 자를 업신여겼도다 부자는 너희를 억압하며 법정으로 끌고 가지 아니하느냐", "But you have insulted the poor. Is it not the rich who are exploiting you? Are they not the ones who are dragging you into court?"));
        ch.add(new Verse("그들은 너희에게 대하여 일컫는 바 그 아름다운 이름을 비방하지 아니하느냐", "Are they not the ones who are slandering the noble name of him to whom you belong?"));
        ch.add(new Verse("너희가 만일 성경에 기록된 대로 네 이웃 사랑하기를 네 몸과 같이 하라 하신 최고의 법을 지키면 잘하는 것이거니와", "If you really keep the royal law found in Scripture, 'Love your neighbor as yourself,' you are doing right."));
        ch.add(new Verse("만일 너희가 사람을 차별하여 대하면 죄를 짓는 것이니 율법이 너희를 범법자로 정죄하리라", "But if you show favoritism, you sin and are convicted by the law as lawbreakers."));
        ch.add(new Verse("누구든지 온 율법을 지키다가 그 하나를 범하면 모두 범한 자가 되나니", "For whoever keeps the whole law and yet stumbles at just one point is guilty of breaking all of it."));
        ch.add(new Verse("간음하지 말라 하신 이가 또한 살인하지 말라 하셨은즉 네가 비록 간음하지 아니하여도 살인하면 율법을 범한 자가 되느니라", "For he who said, 'Do not commit adultery,' also said, 'Do not murder.' If you do not commit adultery but do commit murder, you have become a lawbreaker."));
        ch.add(new Verse("너희는 자유의 율법대로 심판 받을 자처럼 말도 하고 행하기도 하라", "Speak and act as those who are going to be judged by the law that gives freedom,"));
        ch.add(new Verse("긍휼을 행하지 아니하는 자에게는 긍휼 없는 심판이 있으리라 긍휼은 심판을 이기고 자랑하느니라", "because judgment without mercy will be shown to anyone who has not been merciful. Mercy triumphs over judgment!"));
        ch.add(new Verse("내 형제들아 만일 사람이 믿음이 있노라 하고 행함이 없으면 무슨 유익이 있으리요 그 믿음이 능히 자기를 구원하겠느냐", "What good is it, my brothers, if a man claims to have faith but has no deeds? Can such faith save him?"));
        ch.add(new Verse("만일 형제나 자매가 헐벗고 일용할 양식이 없는데", "Suppose a brother or sister is without clothes and daily food."));
        ch.add(new Verse("너희 중에 누구든지 그에게 이르되 평안히 가라, 덥게 하라, 배부르게 하라 하며 그 몸에 쓸 것을 주지 아니하면 무슨 유익이 있으리요", "If one of you says to him, 'Go, I wish you well; keep warm and well fed,' but does nothing about his physical needs, what good is it?"));
        ch.add(new Verse("이와 같이 행함이 없는 믿음은 그 자체가 죽은 것이라", "In the same way, faith by itself, if it is not accompanied by action, is dead."));
        ch.add(new Verse("어떤 사람은 말하기를 너는 믿음이 있고 나는 행함이 있으니 행함이 없는 네 믿음을 내게 보이라 나는 행함으로 내 믿음을 네게 보이리라 하리라", "But someone will say, 'You have faith; I have deeds.' Show me your faith without deeds, and I will show you my faith by what I do."));
        ch.add(new Verse("네가 하나님은 한 분이신 줄을 믿느냐 잘하는도다 귀신들도 믿고 떠느니라", "You believe that there is one God. Good! Even the demons believe that — and shudder."));
        ch.add(new Verse("아아 허탄한 사람아 행함이 없는 믿음이 헛것인 줄을 알고자 하느냐", "You foolish man, do you want evidence that faith without deeds is useless?"));
        ch.add(new Verse("우리 조상 아브라함이 그 아들 이삭을 제단에 바칠 때에 행함으로 의롭다 하심을 받은 것이 아니냐", "Was not our ancestor Abraham considered righteous for what he did when he offered his son Isaac on the altar?"));
        ch.add(new Verse("네가 보거니와 믿음이 그의 행함과 함께 일하고 행함으로 믿음이 온전하게 되었느니라", "You see that his faith and his actions were working together, and his faith was made complete by what he did."));
        ch.add(new Verse("이에 성경에 이른 바 아브라함이 하나님을 믿으니 이것을 의로 여기셨다는 말씀이 이루어졌고 그는 하나님의 벗이라 칭함을 받았느니라", "And the scripture was fulfilled that says, 'Abraham believed God, and it was credited to him as righteousness,' and he was called God's friend."));
        ch.add(new Verse("이로 보건대 사람이 행함으로 의롭다 하심을 받고 믿음으로만은 아니니라", "You see that a person is justified by what he does and not by faith alone."));
        ch.add(new Verse("또 이와 같이 기생 라합이 사자들을 접대하여 다른 길로 나가게 할 때에 행함으로 의롭다 하심을 받은 것이 아니냐", "In the same way, was not even Rahab the prostitute considered righteous for what she did when she gave lodging to the spies and sent them off in a different direction?"));
        ch.add(new Verse("영혼 없는 몸이 죽은 것 같이 행함이 없는 믿음은 죽은 것이니라", "As the body without the spirit is dead, so faith without deeds is dead."));
        chapters.add(ch);

        // 3장 (18절)
        ch = new ArrayList<>();
        ch.add(new Verse("내 형제들아 너희는 선생된 우리가 더 큰 심판을 받을 줄 알고 선생이 많이 되지 말라", "Not many of you should presume to be teachers, my brothers, because you know that we who teach will be judged more strictly."));
        ch.add(new Verse("우리가 다 실수가 많으니 만일 말에 실수가 없는 자라면 곧 온전한 사람이라 능히 온 몸도 굴레 씌우리라", "We all stumble in many ways. If anyone is never at fault in what he says, he is a perfect man, able to keep his whole body in check."));
        ch.add(new Verse("우리가 말들의 입에 재갈 물리는 것은 우리에게 복종하게 하려고 그 온 몸을 제어함이라", "When we put bits into the mouths of horses to make them obey us, we can turn the whole animal."));
        ch.add(new Verse("또 배를 보라 그렇게 크고 광풍에 밀려가는 것들을 지극히 작은 키로 사공의 뜻대로 운전하나니", "Or take ships as an example. Although they are so large and are driven by strong winds, they are steered by a very small rudder wherever the pilot wants to go."));
        ch.add(new Verse("이와 같이 혀도 작은 지체로되 큰 것을 자랑하도다 보라 어떻게 작은 불이 많은 나무를 태우는가", "Likewise the tongue is a small part of the body, but it makes great boasts. Consider what a great forest is set on fire by a small spark."));
        ch.add(new Verse("혀는 곧 불이요 불의의 세계라 혀는 우리 지체 중에서 온 몸을 더럽히고 삶의 수레바퀴를 불사르나니 그 사르는 것이 지옥 불에서 나느니라", "The tongue also is a fire, a world of evil among the parts of the body. It corrupts the whole person, sets the whole course of his life on fire, and is itself set on fire by hell."));
        ch.add(new Verse("여러 종류의 짐승과 새며 벌레와 바다의 생물은 다 사람이 길들일 수 있고 길들여 왔거니와", "All kinds of animals, birds, reptiles and creatures of the sea are being tamed and have been tamed by man,"));
        ch.add(new Verse("혀는 능히 길들일 사람이 없나니 쉬지 아니하는 악이요 죽이는 독이 가득한 것이라", "but no man can tame the tongue. It is a restless evil, full of deadly poison."));
        ch.add(new Verse("이것으로 우리가 주 아버지를 찬송하고 또 이것으로 하나님의 형상대로 지음을 받은 사람을 저주하나니", "With the tongue we praise our Lord and Father, and with it we curse men, who have been made in God's likeness."));
        ch.add(new Verse("한 입에서 찬송과 저주가 나오는도다 내 형제들아 이것이 마땅하지 아니하니라", "Out of the same mouth come praise and cursing. My brothers, this should not be."));
        ch.add(new Verse("샘이 한 구멍으로 어찌 단 물과 쓴 물을 내겠느냐", "Can both fresh water and salt water flow from the same spring?"));
        ch.add(new Verse("내 형제들아 어찌 무화과나무가 감람 열매를, 포도나무가 무화과를 맺겠느냐 이와 같이 짠 물이 단 물을 내지 못하느니라", "My brothers, can a fig tree bear olives, or a grapevine bear figs? Neither can a salt spring produce fresh water."));
        ch.add(new Verse("너희 중에 지혜와 총명이 있는 자가 누구냐 그는 선행으로 말미암아 지혜의 온유함으로 그 행함을 보일지니라", "Who is wise and understanding among you? Let him show it by his good life, by deeds done in the humility that comes from wisdom."));
        ch.add(new Verse("그러나 너희 마음 속에 독한 시기와 다툼이 있으면 자랑하지 말라 진리를 거슬러 거짓말하지 말라", "But if you harbor bitter envy and selfish ambition in your hearts, do not boast about it or deny the truth."));
        ch.add(new Verse("이러한 지혜는 위로부터 내려온 것이 아니요 땅 위의 것이요 정욕의 것이요 귀신의 것이니", "Such 'wisdom' does not come down from heaven but is earthly, unspiritual, of the devil."));
        ch.add(new Verse("시기와 다툼이 있는 곳에는 혼란과 모든 악한 일이 있음이라", "For where you have envy and selfish ambition, there you find disorder and every evil practice."));
        ch.add(new Verse("오직 위로부터 난 지혜는 첫째 성결하고 다음에 화평하고 관용하고 양순하며 긍휼과 선한 열매가 가득하고 편견과 거짓이 없나니", "But the wisdom that comes from heaven is first of all pure; then peace-loving, considerate, submissive, full of mercy and good fruit, impartial and sincere."));
        ch.add(new Verse("화평하게 하는 자들은 화평으로 심어 의의 열매를 거두느니라", "Peacemakers who sow in peace raise a harvest of righteousness."));
        chapters.add(ch);

        // 4장 (17절)
        ch = new ArrayList<>();
        ch.add(new Verse("너희 중에 싸움이 어디로부터 다툼이 어디로부터 나느냐 너희 지체 중에서 싸우는 정욕으로부터 나는 것이 아니냐", "What causes fights and quarrels among you? Don't they come from your desires that battle within you?"));
        ch.add(new Verse("너희는 욕심을 내어도 얻지 못하고 살인하며 시기하여도 능히 취하지 못하므로 다투고 싸우는도다 너희가 얻지 못함은 구하지 아니하기 때문이요", "You want something but don't get it. You kill and covet, but you cannot have what you want. You quarrel and fight. You do not have, because you do not ask God."));
        ch.add(new Verse("구하여도 받지 못함은 정욕으로 쓰려고 잘못 구하기 때문이라", "When you ask, you do not receive, because you ask with wrong motives, that you may spend what you get on your pleasures."));
        ch.add(new Verse("간음한 여인들아 세상과 벗된 것이 하나님과 원수됨을 알지 못하느냐 그런즉 누구든지 세상과 벗이 되고자 하는 자는 스스로 하나님과 원수되는 것이니라", "You adulterous people, don't you know that friendship with the world is hatred toward God? Anyone who chooses to be a friend of the world becomes an enemy of God."));
        ch.add(new Verse("너희는 하나님이 우리 속에 거하게 하신 성령이 시기하기까지 사모한다 하신 말씀을 헛된 줄로 생각하느냐", "Or do you think Scripture says without reason that the spirit he caused to live in us envies intensely?"));
        ch.add(new Verse("그러나 더욱 큰 은혜를 주시나니 그러므로 일렀으되 하나님이 교만한 자를 물리치시고 겸손한 자에게 은혜를 주신다 하였느니라", "But he gives us more grace. That is why Scripture says: 'God opposes the proud but gives grace to the humble.'"));
        ch.add(new Verse("그런즉 너희는 하나님께 복종할지어다 마귀를 대적하라 그리하면 너희를 피하리라", "Submit yourselves, then, to God. Resist the devil, and he will flee from you."));
        ch.add(new Verse("하나님을 가까이하라 그리하면 너희를 가까이하시리라 죄인들아 손을 깨끗이 하라 두 마음을 품은 자들아 마음을 성결하게 하라", "Come near to God and he will come near to you. Wash your hands, you sinners, and purify your hearts, you double-minded."));
        ch.add(new Verse("슬퍼하며 애통하며 울지어다 너희 웃음을 애통으로, 너희 즐거움을 근심으로 바꿀지어다", "Grieve, mourn and wail. Change your laughter to mourning and your joy to gloom."));
        ch.add(new Verse("주 앞에서 낮추라 그리하면 주께서 너희를 높이시리라", "Humble yourselves before the Lord, and he will lift you up."));
        ch.add(new Verse("형제들아 서로 비방하지 말라 형제를 비방하는 자나 형제를 판단하는 자는 곧 율법을 비방하고 율법을 판단하는 것이라 네가 만일 율법을 판단하면 율법의 준행자가 아니요 재판관이로다", "Brothers, do not slander one another. Anyone who speaks against his brother or judges him speaks against the law and judges it. When you judge the law, you are not keeping it, but sitting in judgment on it."));
        ch.add(new Verse("입법자와 재판관은 오직 한 분이시니 능히 구원하기도 하시며 멸하기도 하시느니라 너는 누구이기에 이웃을 판단하느냐", "There is only one Lawgiver and Judge, the one who is able to save and destroy. But you — who are you to judge your neighbor?"));
        ch.add(new Verse("들으라 너희 중에 말하기를 오늘이나 내일이나 우리가 어떤 도시에 가서 거기서 일 년을 머물며 장사하여 이익을 보리라 하는 자들아", "Now listen, you who say, 'Today or tomorrow we will go to this or that city, spend a year there, carry on business and make money.'"));
        ch.add(new Verse("내일 일을 너희가 알지 못하는도다 너희 생명이 무엇이냐 너희는 잠깐 보이다가 없어지는 안개니라", "Why, you do not even know what will happen tomorrow. What is your life? You are a mist that appears for a little while and then vanishes."));
        ch.add(new Verse("너희가 도리어 말하기를 주의 뜻이면 우리가 살기도 하고 이것이나 저것을 하리라 할 것이거늘", "Instead, you ought to say, 'If it is the Lord's will, we will live and do this or that.'"));
        ch.add(new Verse("이제도 너희가 허탄한 자랑을 하니 그러한 자랑은 다 악한 것이라", "As it is, you boast and brag. All such boasting is evil."));
        ch.add(new Verse("그러므로 사람이 선을 행할 줄 알고도 행하지 아니하면 죄니라", "Anyone, then, who knows the good he ought to do and doesn't do it, sins."));
        chapters.add(ch);

        // 5장 (20절)
        ch = new ArrayList<>();
        ch.add(new Verse("들으라 부한 자들아 너희에게 임할 고생으로 말미암아 울고 통곡하라", "Now listen, you rich people, weep and wail because of the misery that is coming upon you."));
        ch.add(new Verse("너희 재물은 썩었고 너희 옷은 좀 먹었으며", "Your wealth has rotted, and moths have eaten your clothes."));
        ch.add(new Verse("너희 금과 은은 녹이 슬었으니 이 녹이 너희에게 증거가 되며 불 같이 너희 살을 먹으리라 너희가 말세에 재물을 쌓았도다", "Your gold and silver are corroded. Their corrosion will testify against you and eat your flesh like fire. You have hoarded wealth in the last days."));
        ch.add(new Verse("보라 너희 밭에서 추수한 품꾼에게 주지 아니한 삯이 소리 지르며 그 추수한 자의 우는 소리가 만군의 주의 귀에 들렸느니라", "Look! The wages you failed to pay the workmen who mowed your fields are crying out against you. The cries of the harvesters have reached the ears of the Lord Almighty."));
        ch.add(new Verse("너희는 땅에서 사치하고 방종하여 살육의 날에 너희 마음을 살찌웠도다", "You have lived on earth in luxury and self-indulgence. You have fattened yourselves in the day of slaughter."));
        ch.add(new Verse("너희는 의인을 정죄하고 죽였으나 그는 너희에게 대항하지 아니하였느니라", "You have condemned and murdered innocent men, who were not opposing you."));
        ch.add(new Verse("그러므로 형제들아 주께서 강림하시기까지 길이 참으라 보라 농부가 땅에서 나는 귀한 열매를 바라고 길이 참아 이른 비와 늦은 비를 기다리나니", "Be patient, then, brothers, until the Lord's coming. See how the farmer waits for the land to yield its valuable crop, patiently waiting for the autumn and spring rains."));
        ch.add(new Verse("너희도 길이 참고 마음을 굳건하게 하라 주의 강림이 가까우니라", "You too, be patient and stand firm, because the Lord's coming is near."));
        ch.add(new Verse("형제들아 서로 원망하지 말라 그리하여야 심판을 면하리라 보라 심판주가 문 앞에 서 계시니라", "Don't grumble against each other, brothers, or you will be judged. The Judge is standing at the door!"));
        ch.add(new Verse("형제들아 주의 이름으로 말한 선지자들을 고난과 오래 참음의 본으로 삼으라", "Brothers, as an example of patience in the face of suffering, take the prophets who spoke in the name of the Lord."));
        ch.add(new Verse("보라 인내하는 자를 우리가 복되다 하나니 너희가 욥의 인내를 들었고 주께서 주신 결말을 보았거니와 주는 가장 자비하시고 긍휼히 여기시는 이시니라", "As you know, we consider blessed those who have persevered. You have heard of Job's perseverance and have seen what the Lord finally brought about. The Lord is full of compassion and mercy."));
        ch.add(new Verse("내 형제들아 무엇보다도 맹세하지 말지니 하늘로나 땅으로나 아무 다른 것으로도 맹세하지 말고 오직 너희가 그렇다고 할 것은 그렇다 하고 아니라 할 것은 아니라 하여 정죄 받음을 면하라", "Above all, my brothers, do not swear — not by heaven or by earth or by anything else. Let your 'Yes' be yes, and your 'No,' no, or you will be condemned."));
        ch.add(new Verse("너희 중에 고난 당하는 자가 있느냐 그는 기도할 것이요 즐거워하는 자가 있느냐 그는 찬송할지니라", "Is any one of you in trouble? He should pray. Is anyone happy? Let him sing songs of praise."));
        ch.add(new Verse("너희 중에 병든 자가 있느냐 그는 교회의 장로들을 청할 것이요 그들은 주의 이름으로 기름을 바르며 위하여 기도할지니라", "Is any one of you sick? He should call the elders of the church to pray over him and anoint him with oil in the name of the Lord."));
        ch.add(new Verse("믿음의 기도는 병든 자를 구원하리니 주께서 그를 일으키시리라 혹시 죄를 범하였을지라도 사하심을 받으리라", "And the prayer offered in faith will make the sick person well; the Lord will raise him up. If he has sinned, he will be forgiven."));
        ch.add(new Verse("그러므로 너희 죄를 서로 고백하며 병이 낫기를 위하여 서로 기도하라 의인의 간구는 역사하는 힘이 큼이니라", "Therefore confess your sins to each other and pray for each other so that you may be healed. The prayer of a righteous man is powerful and effective."));
        ch.add(new Verse("엘리야는 우리와 성정이 같은 사람이로되 그가 비가 오지 않기를 간절히 기도한즉 삼 년 육 개월 동안 땅에 비가 오지 아니하고", "Elijah was a man just like us. He prayed earnestly that it would not rain, and it did not rain on the land for three and a half years."));
        ch.add(new Verse("다시 기도하니 하늘이 비를 주고 땅이 열매를 맺었느니라", "Again he prayed, and the heavens gave rain, and the earth produced its crops."));
        ch.add(new Verse("내 형제들아 너희 중에 미혹된 자를 누가 돌아서게 하면", "My brothers, if one of you should wander from the truth and someone should bring him back,"));
        ch.add(new Verse("죄인을 미혹된 길에서 돌아서게 하는 자가 그의 영혼을 사망에서 구원할 것이며 허다한 죄를 덮을 것임을 알지니라", "remember this: Whoever turns a sinner from the error of his way will save him from death and cover over a multitude of sins."));
        chapters.add(ch);

        return chapters;
    }

    private BibleData() {}
}
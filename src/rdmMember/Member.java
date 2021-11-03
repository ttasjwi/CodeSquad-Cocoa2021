package rdmMember;

import java.util.HashSet;
import java.util.Set;

enum Member {
    땃쥐, donggi, Jerry, Hoo, Tany, 노리, 피오, K, taksu, Mk, mandoo;

    static final Member[] MEMBERS = Member.values();

    static final int count() {
        return MEMBERS.length;
    }

    // 임의의 멤버를 반환함
    static Member rdmMember() {
        int rdmIndex = (int)(Math.random()*count());
        return MEMBERS[rdmIndex];
    }

    // 지정 인원수만큼 임의의 멤버들을 반환
    static Set<Member> randomSet(final int nmbOfMember) {
        final Set<Member> randomMembers = new HashSet<>();
        while(randomMembers.size() < nmbOfMember) {
             randomMembers.add(rdmMember());
        }
        return randomMembers;
    }

}
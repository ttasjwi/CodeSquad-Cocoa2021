package rdmMember;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final int nmbOfMembers = Prompt.input();
        final Set<Member> randomMembers = Member.randomSet(nmbOfMembers);
        Prompt.print(randomMembers);
    }
}

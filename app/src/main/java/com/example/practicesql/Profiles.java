package com.example.practicesql;

import java.io.Serializable;

public class Profiles implements Serializable {
    String ccid="https://www.codechef.com/users/";
    String cfid="https://codeforces.com/profile/";
    String lcid="https://leetcode.com/";
    String gfgid="https://auth.geeksforgeeks.org/user/";
    String gitid="https://github.com/";
    String cnid="https://www.codingninjas.com/";
    String hackid="https://www.hackerrank.com/";
    Profiles(String cc,String cf,String lc,String gfg,String cn,String git,String hack)
    {
        this.ccid+=cc;
        this.cfid+=cf;
        this.lcid+=lc;
        this.gfgid+=gfg;
        this.cnid+=cn;
        this.gitid+=git;
        this.hackid+=hack;
    }
}

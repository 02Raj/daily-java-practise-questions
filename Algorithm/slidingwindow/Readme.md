# 🪟 Sliding Window — Fixed Type

**Package:** `Algorithm.slidingwindow.fixed`

---

## 🧠 Concept Ek Line Mein

> **Purana element bahar, naya element andar — dobara sum mat karo!**

---

## 🚂 Real Life Trick — Train Wali

Soch tu train mein baith ke khidki se bahar dekh raha hai.
- Khidki ki size **fix** hai (yahi K hai)
- Train aage badhti hai → purani cheez **left se jaati hai**
- Nayi cheez **right se aati hai**
- Tune poori duniya dobara nahi dekhi — bas **ek cheez gayi, ek aayi!**

**Yahi Sliding Window hai! 🎯**

---

## 🔑 Golden Formula — YAAD KAR LE

```
new_sum = old_sum - element_going_OUT + element_coming_IN
```

```java
windowSum += arr[i];        // naya andar
windowSum -= arr[i - k];    // purana bahar
```

**Bas yahi hai poora fixed window! Kuch nahi aur.**

---

## 👁️ Recognize Kaise Karein? — 3 Signals

### ✅ Signal 1 — K seedha diya hoga
```
"subarray of size 3"
"window of size k"
"every k consecutive elements"
```

### ✅ Signal 2 — Yeh words dikhein
```
"consecutive"
"subarray of length k"
"every window"
```

### ❌ Signal 3 — Yeh dikhein toh VARIABLE hai (Fixed nahi!)
```
"longest"       → Variable Window
"smallest"      → Variable Window
"minimum length" → Variable Window
```

---

## 🏗️ Template — Hamesha Yahi Structure

```java
package Algorithm.slidingwindow.fixed;

public class TemplateFixed {
    public static void main(String[] args) {
        int[] arr = { /* tera array */ };
        int k =     /* window size */ ;

        // STEP 1: Pehli window banana (0 to k-1)
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int result = windowSum; // max ya min ya kuch bhi

        // STEP 2: Window slide karo (k to arr.length-1)
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i];        // naya andar
            windowSum -= arr[i - k];    // purana bahar

            // apna logic yahan:
            result = Math.max(result, windowSum); // ya Math.min
        }

        System.out.println("Answer: " + result);
    }
}
```

---

## 📊 Loop Logic — Yaad Rakhna

```
Loop 1 → i = 0    to k-1         → Pehli window BANAO
Loop 2 → i = k    to length-1    → Window SLIDE karo

i - k  →  hamesha OUT jaane wala element!
```

```
arr = [2, 4, 1, 7, 3, 5],  k = 3

Pehli window:
[2, 4, 1] = 7

Sliding:
i=3 → andar arr[3]=7, bahar arr[0]=2 → 7+7-2=12
i=4 → andar arr[4]=3, bahar arr[1]=4 → 12+3-4=11
i=5 → andar arr[5]=5, bahar arr[2]=1 → 11+5-1=15
```

---

## ⚠️ Common Bugs — Dhyan Rakh!

| Bug | Galat | Sahi |
|-----|-------|------|
| Min dhundna hai par | `Math.max` laga diya | `Math.min` lagao |
| Print galat | `"Max Sum"` print kiya min mein | Name match karo |
| Loop start | Loop 2 `i=0` se shuru | Loop 2 `i=k` se shuru |
| Bahar jaana | `arr[i-1]` likha | `arr[i-k]` likhna hai |

---

## 📁 Is Package Mein Kya Hai

```
fixed/
├── README.md                  ← YEH FILE (concept + tricks)
├── MaxSumSubarray.java        ✅ Done
├── MinSumSubarray.java        ✅ Done
├── AverageOfSubarray.java     ⬜ Next
├── FirstNegativeInWindow.java ⬜ Baad Mein
└── CountAnagram.java          ⬜ Baad Mein
```

---

## 🎯 Quick Revision — 30 Second Mein

```
1. K diya?          → Fixed Window
2. Pehle 0 to k-1  → pehli window banao
3. Phir k to end   → slide karo
4. Formula:         new = old - OUT + IN
5. i-k             → hamesha OUT wala element
```

---

## 🧪 Practice Questions — Ek Ek Karke Karo

```
1. ✅ Max Sum Subarray of size k
2. ✅ Min Sum Subarray of size k
3. ⬜ Average of every window of size k
4. ⬜ First negative number in every window of size k
5. ⬜ Count occurrences of anagram (strings)
```

---

*Bhai jab bhi bhool jaye — yeh file khol aur 30 second mein sab yaad aa jayega! 🚀*
package com.meterial.demo.commonActivity.retail;

import com.meterial.demo.R;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LY on 2016/9/7.
 */
public class DataImportUtils {

    public static List<DataInfo> init() {
        DataInfo r1 = new DataInfo();
        r1.cover = R.drawable.a6;
        r1.logo = R.mipmap.ic_launcher;
        r1.title = "10 Free 4 X 6 Prints";
        r1.subTitle = "Online Code";

        DataInfo r2 = new DataInfo();
        r2.cover =  R.drawable.a6;
        r2.logo = R.mipmap.ic_launcher;
        r2.title = "$20 Off $85+";
        r2.subTitle = "In-Store & Online";

        DataInfo r3 = new DataInfo();
        r3.cover =  R.drawable.a6;
        r3.logo = R.mipmap.ic_launcher;
        r3.title = "$30 Off $90";
        r3.subTitle = "Online Code";

        DataInfo r4 = new DataInfo();
        r4.cover =  R.drawable.a6;
        r4.logo = R.mipmap.ic_launcher;
        r4.title = "Free Lip Gloss on $15+";
        r4.subTitle = "Online Code";

        DataInfo r5 = new DataInfo();
        r5.cover =  R.drawable.a6;
        r5.logo = R.mipmap.ic_launcher;
        r5.title = "30% Off Select Prices";
        r5.subTitle = "Online Sale";

        DataInfo r6 = new DataInfo();
        r6.cover =  R.drawable.a6;
        r6.logo = R.mipmap.ic_launcher;
        r6.title = "Up to 70% Off";
        r6.subTitle = "Labor Day Online Sale";

        DataInfo r7 = new DataInfo();
        r7.cover =  R.drawable.a6;
        r7.logo = R.mipmap.ic_launcher;
        r7.title = "Play to Win Up to $50";
        r7.subTitle = "You could even win $5k!";

        DataInfo r8 = new DataInfo();
        r8.cover = R.drawable.a6;
        r8.logo = R.mipmap.ic_launcher;
        r8.title = "Fares from $39 One Way";
        r8.subTitle = "Hot 2 Day Sale";

        return Arrays.asList(new DataInfo[]{r1, r2, r3, r4, r5, r6, r7, r8 });
    }
}
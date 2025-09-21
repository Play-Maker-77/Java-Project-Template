public class Division {
    int division;
    String divisionName;

    public Division(int division) {
        this.division = division;
        setDivision();
    }

    private void setDivision()
    {
        switch (division)
        {
            case 1:
            {
                divisionName = "Bronze";
                break;
            }
            case 2:
            {
                divisionName = "Silver";
                break;
            }
            case 3:
            {
                divisionName = "Gold";
                break;
            }
            case 4:
            {
                divisionName = "Platinum";
                break;
            }
            case 5:
            {
                divisionName = "Diamond";
                break;
            }
            case 6:
            {
                divisionName = "Champion";
                break;
            }
            case 7:
            {
                divisionName = "Ultimate Champion";
                break;
            }
        }
    }




    @Override
    public String toString()
    {
        return divisionName;
    }
}


public class Knife {
	public void Clean(Potato p)
    {
        if (p.getHave_skin())
        {
            p.setHave_skin(false);
        }
    }

    /// ћетод принимает картошку, если есть кожура - удал€ет
    public void Slice(Potato p)
    {
        p.setHave_parts(10);
    }
}


public class Knife {
	public void Clean(Potato p)
    {
        if (p.getHave_skin())
        {
            p.setHave_skin(false);
        }
    }

    /// ����� ��������� ��������, ���� ���� ������ - �������
    public void Slice(Potato p)
    {
        p.setHave_parts(10);
    }
}

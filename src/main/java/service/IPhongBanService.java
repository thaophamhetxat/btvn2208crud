package service;

import moduls.Employee;
import moduls.PhongBan;

import java.util.ArrayList;

public interface IPhongBanService {
    ArrayList<PhongBan> ShowAllPhongBan();
    PhongBan findbyId(int id);
}

package service;

import moduls.PhongBan;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IPhongBanRepo;

import java.util.ArrayList;

public class PhongBanService implements IPhongBanService{
    @Autowired
    IPhongBanRepo iPhongBanRepo;
    @Override
    public ArrayList<PhongBan> ShowAllPhongBan() {
        return (ArrayList<PhongBan>) iPhongBanRepo.findAll();
    }

    @Override
    public void edit(PhongBan phongBan) {
        iPhongBanRepo.save(phongBan);
    }
}

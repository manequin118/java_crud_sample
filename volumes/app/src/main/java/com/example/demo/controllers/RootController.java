package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.cfg.defs.Mod10CheckDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.models.ItemForm;
import com.example.demo.service.ItemService;
import com.example.demo.entity.ItemEntity;



@Controller
@RequestMapping("/")
public class RootController {
	
	@Autowired
	ItemService itemService;
	
	/**
	 * お問い合わせ一覧を取り出す
	 * @param model
	 * @return
	 */
	@GetMapping ("/itemList")
	public String itemList(Model model) {
		List<ItemEntity> list = itemService.findAll();
		model.addAttribute("itemList", list);

		return "root/itemList";
	}
	
	
    /**
     * 商品登録画面のリクエスト
     * @param itemForm
     * @return
     */

	@GetMapping("/form")
	public String form(ItemForm itemForm) {
		return "root/form";
	}
	
    /**
     * お問い合わせ画面のフォームにある情報をitemRepositoryに保存
     * @param itemForm
     * @param bindingResult
     * @param model
     * @return
     */

	@PostMapping("/form")
	public String form(@Validated  ItemForm itemForm,
			BindingResult bindingResult, 
			ItemEntity itemEntity,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "root/form";
		}

		// RDBと連携できることを確認しておきます。
		itemService.save(itemEntity);
		itemForm.clear();
		model.addAttribute("ItemForm", itemForm);
		model.addAttribute("message", "商品登録完了致しました。");
		
		return "root/form";  
	}
	
	/**
	 * 編集画面
	 * findByIdで単一のレコード文の情報を取り出しでget()メソッドで
	 * optionalから
	 * @param id
	 * @param model
	 * @return
	 */

	@GetMapping("/edit/{id}")
    public String edititem(@PathVariable Long id,Model model) { 
		Optional<ItemEntity> itemEnt = itemService.findById(id);
		ItemEntity item = itemEnt.get();
		
		model.addAttribute("itemEntity", item);
        return "root/edit";
    }
	/**
	 * 編集メソッド
	 * 入力して保存処理、リストのitemFormをとってきて編集後の画面を表示
	 * @param itemForm
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	
	@PostMapping("/update/{id}")
	public String editsave(@Validated @ModelAttribute ItemForm itemForm,
					       BindingResult bindingResult, 
					       ItemEntity itemEntity,
					       Model model) {
				if (bindingResult.hasErrors()) {
					return "root/edit";
				}
				itemService.save(itemEntity);
			
				List<ItemEntity> list = itemService.findAll();
				model.addAttribute("itemList", list);
				
				return "root/itemList";
	    }
	/**
	 * 参照画面にoptional型の単一idをとってきて表示
	 *
	 * @param id
	 * @param model
	 * @return
//	 */

	
	@GetMapping("/view/{id}")
	public String confirmitem(@PathVariable Long id,Model model) {
		 Optional<ItemEntity> itemEnt = itemService.findById(id);
		 ItemEntity item2 =  itemEnt.get();
		 model.addAttribute("ItemEntity", item2);
		 return "root/view";
	}
	/**
	 * 削除メソッド
	 * deleteメソッドにitemFormを引数に渡してリストのitemFormを取得して画面に表示
	 * @param id
	 * @param itemForm
	 * @param model
	 * @return
	 */
	 
	 @GetMapping("/delete/{id}")
	    public String destroy(ItemEntity itemEntity,Model model) {
	        itemService.delete(itemEntity);
	        List<ItemEntity> list = itemService.findAll();
			model.addAttribute("itemList", list);
	        return "root/itemList";
	    }
}
	
	
	
